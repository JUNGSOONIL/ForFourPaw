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
	
	@Override
	public List<DatasetDto> matching(Map<String, String> map) {
		DatasetDto missdto = new DatasetDto();
		missdto.setSexCd(map.get("sexCd"));
		missdto.setColorCd(map.get("colorCd"));
		missdto.setOrgNm(map.get("orgNm"));
		ArrayList<DatasetDto> list = new ArrayList<DatasetDto>();
		list.add(missdto);
		list.addAll(missMatchtDao.DataSelect(map));

		if(list.size() == 1) 
			return null;
		
		// DB에서 가져온 내용으로 CSV 파일 만듬
		String[] gugun = new String[] {"인천광역시","서울특별시","경기도","강원도","세종특별자치시","대전광역시","충청남도","충청북도","경상북도","대구광역시","울산광역시","경상남도","부산광역시","전라북도","전라남도","광주광역시","제주특별자치도"};
		String[] sex = new String[] {"F","Q","M"};
		String[] color = new String[] {"흰","힌","휜","하","화","백","white","베","아이","황","크림","노","누","골","금","gold","붉","빨","분","커피","브라","갈","밤","쵸","초코","초콜","초","녹","실버","그","회","감장","흑","블","검","black","바둑","젖소","점박","얼룩","삼색","호피","블루","고","치즈","턱시","코숏"};
		File csv = new File("src/main/resources/recommend.csv");
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
		String path = "src/main/resources/recommend.csv";

		SparkConf conf = new SparkConf().setAppName("JavaKMeansExample").setMaster("local");
		JavaSparkContext jsc = new JavaSparkContext(conf);
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
		jsc.stop();
		
		result.sort((a,b) -> b.getHappenDt().compareTo(a.getHappenDt()));
		
		return result;
	}
	
//	public void test() {
//		SparkConf conf = new SparkConf().setAppName("JavaKMeansExample").setMaster("local");
//		JavaSparkContext jsc = new JavaSparkContext(conf);
//
//		// $example on$
//		// Load and parse data
//		String path = "src/main/resources/recommend.csv";
//
//		JavaRDD<String> data = jsc.textFile(path);
//
//	    data.foreach(s -> {
//	    	String[] sarray = s.split("\\|");
//			DatasetDto dto = new DatasetDto();
//			dto.setDesertionNo(sarray[0]);
//			dto.setFilename(sarray[1]);
//			dto.setHappenDt(sarray[2]);
//			dto.setHappenPlace(sarray[3]);
//			dto.setKindCd(sarray[4]);
//			dto.setColorCd(sarray[5]);
//			dto.setAge(sarray[6]);
//			dto.setWeight(sarray[7]);
//			dto.setNoticeNo(sarray[8]);
//			dto.setNoticeSdt(sarray[9]);
//			dto.setNoticeEdt(sarray[10]);
//			dto.setPopfile(sarray[11]);
//			dto.setProcessState(sarray[12]);
//			dto.setSexCd(sarray[13]);
//			dto.setNeuterYn(sarray[14]);
//			dto.setSpecialMark(sarray[15]);
//			dto.setCareNm(sarray[16]);
//			dto.setCareTel(sarray[17]);
//			dto.setCareAddr(sarray[18]);
//			dto.setOrgNm(sarray[19]);
//			dto.setChargeNm(sarray[20]);
//			dto.setOfficetel(sarray[21]);
//			list.add(dto);
//	    });
//	        
//		JavaRDD<Vector> parsedData = data.map(s -> {
//			String[] sarray = s.split("\\|");
//			double[] values = new double[3];
//			values[0] = Double.parseDouble(sarray[5]);
//			values[1] = Double.parseDouble(sarray[13]);
//			values[2] = Double.parseDouble(sarray[19]);
//			return Vectors.dense(values);
//		});
//
//		parsedData.cache();
//
//		// Cluster the data into two classes using KMeans
//		int numClusters = (int) data.count();
//		int numIterations = 20;
//
//		KMeansModel clusters = KMeans.train(parsedData.rdd(), numClusters, numIterations);
//
////	    System.out.println("Cluster centers:");
////	    for (Vector center: clusters.clusterCenters()) {
////	      System.out.println(" " + center);
////	    }
//
////	    // Evaluate clustering by computing Within Set Sum of Squared Errors
////	    double WSSSE = clusters.computeCost(parsedData.rdd());
////	    System.out.println("Within Set Sum of Squared Errors = " + WSSSE);
//		System.out.println(clusters.predict(parsedData).collect());
//
//		double cost = clusters.computeCost(parsedData.rdd());
//		System.out.println("Cost: " + cost);
//
//		List<Integer> result = clusters.predict(parsedData).collect();
//		for (int j = 0; j < result.size(); j++) {
//			if (result.get(j) == 3)
//				System.out.println(list.get(j));
//		}
//		System.out.println("\n" + list.size());
//
////	    // Save and load model
////	    clusters.save(jsc.sc(), "target/org/apache/spark/JavaKMeansExample/KMeansModel");
////	    KMeansModel sameModel = KMeansModel.load(jsc.sc(),"target/org/apache/spark/JavaKMeansExample/KMeansModel");
////	    // $example off$
//
//		jsc.stop();
//	}
}