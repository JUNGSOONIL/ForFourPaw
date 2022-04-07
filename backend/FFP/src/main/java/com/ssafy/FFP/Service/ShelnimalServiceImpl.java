package com.ssafy.FFP.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.FFP.Dao.ShelnimalDao;
import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import com.ssafy.FFP.Dto.ViewStoreDto;

@Service
public class ShelnimalServiceImpl implements ShelnimalService {
	
	private static final int SUCCESS = 1;
    private static final int FAIL = -1;
	
	static class Node{
		String shelnimalId; // 반려동물 Id
		double degree;
		public String getShelnimalId() {
			return shelnimalId;
		}
		public void setShelnimalId(String shelnimalId) {
			this.shelnimalId = shelnimalId;
		}
		public double getDegree() {
			return degree;
		}
		public void setDegree(double degree) {
			this.degree = degree;
		}
		public Node(String shelnimalId, double degree) {
			super();
			this.shelnimalId = shelnimalId;
			this.degree = degree;
		}
		@Override
		public String toString() {
			return "Node [shelnimalId=" + shelnimalId + ", degree=" + degree + "]";
		}
		
		
	}
	
	// String 내림차순
	static class DescendingObj implements Comparator<Node> {
	 
	    @Override
	    public int compare(Node o1, Node o2) {
	        if(o1.getDegree() < o2.getDegree()) return 1;
	        if(o1.getDegree() > o2.getDegree()) return -1;
	        return 0;
	    }
	}
	
    @Autowired
    ShelnimalDao shelnimalDao;

    @Override
    public ShelnimalDto select(String no) {
        ShelnimalDto shelnimalDto = shelnimalDao.select(no);
        return shelnimalDto;
    }

	@Override
	public int insert(ShelnimalDto data) {
		return shelnimalDao.insert(data);
	}

	@Override
    public List<ShelnimalDto> list(int sdt, int offset, int limit) {
        List<ShelnimalDto> shelnimalDtos = shelnimalDao.list(sdt, offset, limit);
        return shelnimalDtos;

    }

    @Override
    public List<ShelnimalDto> match(int userNo) {
        List<ShelnimalDto> shelnimalDtos = shelnimalDao.match(userNo);
        return shelnimalDtos;
    }

    @Override
    public List<ShelnimalDto> find(SearchDto searchDto) {
        return shelnimalDao.find(searchDto);
    }

	@Override
	public List<DatasetDto> mainList() {
		String processState = "보호중";
		List<DatasetDto> shelnimalDtos = shelnimalDao.mainList(processState);
		return shelnimalDtos;
	}

	@Override
	public List<String> searchList(String kind) {
		System.out.println(kind);
		List<String> kinds = shelnimalDao.searchList(kind);
		System.out.println(kinds);
		return kinds;
	}

	@Override
	public List<DatasetDto> mainListLogin(String no) {
		if(shelnimalDao.userCount() == 0) {
			System.out.println("1");
			String processState = "보호중";
			List<DatasetDto> shelnimalDtos = shelnimalDao.mainList(processState);
			return shelnimalDtos;
		}else {
			System.out.println("2");
			int N = shelnimalDao.userCount(); // total user count
//			System.out.println("mainListLogin : " + N);
			
			int[][] sparseMatrix = new int[N][N]; // 사용자 유사도 계산을 위한 사용자 스파스 매트릭스 [Similarity matrix]
			
			String[] userInfo = shelnimalDao.userInfo(); // 모든 유저 정보
//			System.out.println("mainListLogin : " + Arrays.toString(userInfo));
			
			Map<String, Integer> userItemLength = new HashMap<>();
			// 사용자별로 다른 아이템의 합계 수(예: A 3 )
			Map<String, Set<String>> itemUserCollection = new HashMap<>();
			// 사용자에게 항목의 반전 목록을 만듭니다.
			Set<String> items = new HashSet<>();
			// 아이템 컬렉션 저장
			Map<String, Integer> userID = new HashMap<>();
			// 1명당 세컨더리 스토리지 모든 사용자 ID 매핑
			Map<Integer, String> idUser = new HashMap<>();
			// 1개의 ID당 Secondary 스토리지 대응하는 사용자 매핑
			
			// 입력 사용자--항목 매핑 정보:<예: A a b d>
			for (int i = 0; i < N; i++) {
				String[] user_item = shelnimalDao.userItem(userInfo[i]);
				int length = user_item.length;
				userItemLength.put(userInfo[i], length);
				// A 3
				userID.put(userInfo[i], i);
				// 사용자 ID 해당 관계는 스파스 매트릭스를 사용하여 확립됩니다.
				idUser.put(i, userInfo[i]);
				// 항목 설정 - 사용자 반전 목록
				for (int j = 0; j < length; j++) {
					if(items.contains(user_item[j])) {
						// 해당 항목이 이미 포함된 경우 - User mapping, 해당 사용자를 직접 추가합니다.
						itemUserCollection.get(user_item[j]).add(userInfo[i]);
					} else {
						// 그렇지 않으면 해당 항목을 작성합니다. -- User set mapping
						items.add(user_item[j]);
						itemUserCollection.put(user_item[j], new HashSet<String>());
						// 오브젝트 작성 - 사용자 반전 관계
						itemUserCollection.get(user_item[j]).add(userInfo[i]);
					}
				}
			}
//			System.out.println("mainListLogin : itemUserCollection : " + itemUserCollection.toString());
			//유사도 행렬 계산 [Sparse]
			Set<Entry<String, Set<String>>> entrySet = itemUserCollection.entrySet();
			Iterator<Entry<String, Set<String>>> iterator = entrySet.iterator();
			while(iterator.hasNext()) {
				Set<String> commonUsers = iterator.next().getValue();
				for (String user_u : commonUsers) {
					for (String user_v : commonUsers) {
						if(user_u.equals(user_v)) {
							continue;
						}
						sparseMatrix[userID.get(user_u)][userID.get(user_v)] += 1;
						// 사용자 계산 u 사용자와 함께 v 긍정적인 피드백이 있는 총 항목 수
					}
				}
			}
//			System.out.println("mainListLogin : " + userItemLength.toString());
//			System.out.println("Input the user for recommendation:<eg:A>");
			String recommendUser = no;
//			System.out.println("mainListLogin : " + userID.get(recommendUser));
			// 사용자 간 유사도 계산 [cosine similarity]
//			int recommendUserId = userID.get(recommendUser);
//			for (int i = 0; i < sparseMatrix.length; i++) {
//				if(i != recommendUserId) {
//					System.out.println(idUser.get(recommendUserId)+"--"+idUser.get(i)+" similarity :"+sparseMatrix[recommendUserId][i]/Math.sqrt(userItemLength.get(idUser.get(recommendUserId))*userItemLength.get(idUser.get(i))));
//				}
//				
//			}
			
			ArrayList<Node> recommend = new ArrayList<Node>();
			// 지정된 사용자 권장 사용자 항목 권장 사항 계산
			for (String item: items){
				// 1개 항목마다 이동  
				Set<String> users = itemUserCollection.get(item);
				// 현재 항목을 조회한 모든 사용자의 컬렉션을 가져옵니다. 
				if(!users.contains(recommendUser)){
					// 권장 사용자가 현재 아이템을 구입하지 않은 경우 권장 사항이 계산됩니다. 
					double itemRecommendDegree = 0.0;
					for (String user: users){
						if(userID.get(recommendUser) == null) {
							String processState = "보호중";
							List<DatasetDto> shelnimalDtos = shelnimalDao.mainList(processState);
							return shelnimalDtos;	
						}
						itemRecommendDegree += sparseMatrix[userID.get(recommendUser)][userID.get(user)]/Math.sqrt(userItemLength.get(recommendUser)*userItemLength.get(user));
						// 권장계산
					}
//					System.out.println("The item "+item+" for "+recommendUser +"'s recommended degree:"+itemRecommendDegree);
					recommend.add(new Node(item, itemRecommendDegree));
				}
			}
			
			DescendingObj descending = new DescendingObj();
	        Collections.sort(recommend, descending);
	        
	        if(items.size() < 6 || recommend.size() < 6) {
	        	String processState = "보호중";
	    		List<DatasetDto> shelnimalDtos = shelnimalDao.mainList(processState);
	    		System.out.println(shelnimalDtos.toString());
	    		return shelnimalDtos;
	        }else {
	        	List<String> shelnimalIds = new ArrayList<String>();
	        	for (int i = 0; i < 6; i++) {
					Node node = recommend.get(i);
					shelnimalIds.add(node.getShelnimalId());
				}

	        	List<DatasetDto> shelnimalDtos = shelnimalDao.mainListLogin(shelnimalIds);
	        	System.out.println("6개이상 " + shelnimalDtos.toString());
	    		return shelnimalDtos;
	        }
		}
		
        
	}

	@Override
	public int viewStore(ViewStoreDto viewStoreDto) {
		
		if (shelnimalDao.viewStore(viewStoreDto) == SUCCESS) // 성공
            return SUCCESS;
        else // 실패
            return FAIL;
	}
}
