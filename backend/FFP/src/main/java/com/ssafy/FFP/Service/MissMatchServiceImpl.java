package com.ssafy.FFP.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import org.apache.spark.mllib.clustering.KMeans;
import org.apache.spark.mllib.clustering.KMeansModel;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.FFP.Dao.MissMatchDao;
import com.ssafy.FFP.Dto.DatasetDto;

@Service
public class MissMatchServiceImpl implements MissMatchService {

	@Autowired
	MissMatchDao missMatchtDao;
	
	static SparkConf conf = new SparkConf().setAppName("JavaKMeansExample").setMaster("local").set("spark.driver.allowMultipleContexts","true");
	static JavaSparkContext jsc = new JavaSparkContext(conf);

	@Override
	public List<DatasetDto> matching(Map<String, String> map) {
		DatasetDto missdto = new DatasetDto();
		missdto.setSexCd(map.get("sexCd"));
		missdto.setColorCd(map.get("colorCd"));
		missdto.setOrgNm(map.get("happenPlace"));
		ArrayList<DatasetDto> list = new ArrayList<DatasetDto>();
		list.add(missdto);
		list.addAll(missMatchtDao.DataSelect(map));

		if(list.size() == 1)
			return null;

		// DB에서 가져온 내용으로 CSV 파일 만듬
		String[] gugun = new String[] {"인천광역시","서울특별시","경기도","강원도","세종특별자치시","대전광역시","충청남도","충청북도","경상북도","대구광역시","울산광역시","경상남도","부산광역시","전라북도","전라남도","광주광역시","제주특별자치도"};
		String[] sex = new String[] {"F","Q","M"};
		String[] color = new String[] {"흰","힌","휜","하","화","백","white","베","아이","황","크림","노","누","골","금","gold","붉","빨","분","커피","브라","갈","밤","쵸","초코","초콜","초","녹","실버","그","회","감장","흑","블","검","black","바둑","젖소","점박","얼룩","삼색","호피","블루","고","치즈","턱시","코숏"};
		File csv = new File("/recommend.csv");
		BufferedWriter bw = null; // 출력 스트림 생성
		try {
			bw = new BufferedWriter(new FileWriter(csv));
			for (DatasetDto dto : list) {
				String Sexcd= "";
				String ColorCd= "";
				String OrgNm= "";
				for (int i = 0; i < gugun.length; i++) {
					if(dto.getOrgNm().contains(gugun[i])) {
						OrgNm = i+"";
						break;
					}
				}
				for (int i = 0; i < sex.length; i++) {
					if(dto.getSexCd().contains(sex[i])) {
						Sexcd = i+"";
						break;
					}
				}
				for (int i = 0; i < color.length; i++) {
					if(dto.getColorCd().contains(color[i])) {
						ColorCd = i+"";
						break;
					}
					if(i == color.length - 1)
						ColorCd=color.length+"";
				}
				String str = Sexcd +"|" + ColorCd + "|" + OrgNm;
				bw.write(str);
				// 작성한 데이터를 파일에 넣는다
				bw.newLine(); // 개행
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush(); // 남아있는 데이터까지 보내 준다
					bw.close(); // 사용한 BufferedWriter를 닫아 준다
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// CSV 파일 읽고 Kmeans 돌리기
		String path = "/recommend.csv";
		
		JavaRDD<String> data = jsc.textFile(path);

		JavaRDD<Vector> parsedData = data.map(s -> {
			String[] sarray = s.split("\\|");
			double[] values = new double[sarray.length]; 
			for (int i = 0; i < sarray.length; i++) {
				values[i] = Double.parseDouble(sarray[i]);
			}
			return Vectors.dense(values);
		});

		parsedData.cache();

		int numClusters = (int) data.count();
		int numIterations = 20;

		KMeansModel clusters = KMeans.train(parsedData.rdd(), numClusters, numIterations);

		List<DatasetDto> result = new ArrayList<DatasetDto>();

		List<Integer> result_int = clusters.predict(parsedData).collect();
		for (int j = 1; j < result_int.size(); j++) {
			if (result_int.get(j) == result_int.get(0))
				result.add(list.get(j));
		}
//		jsc.stop(); 
 
		result.sort((a,b) -> b.getHappenDt().compareTo(a.getHappenDt()));

		return result;
	}
}