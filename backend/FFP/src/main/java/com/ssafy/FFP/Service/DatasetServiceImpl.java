package com.ssafy.FFP.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.FFP.Dao.DatasetDao;
import com.ssafy.FFP.Dto.DatasetDto;

@Service
public class DatasetServiceImpl implements DatasetService {

	@Autowired
	DatasetDao datasetDao;

	@Override
	public int DataInsert() {
		int[] max = new int[] {11,24940,62796,60605,76944,81773,78809,80455,88530,100837,118711,133535,128888,117077}; // 2021년도까지 가능 
		int ans = 0;
		int start = 20070101;
		int end = 20071231;
		for (int t = 0; t < max.length; t++) {
			int result = 0;
			int page = max[t]%1000 == 0 ? max[t]/1000: max[t]/1000 + 1;
			start += 10000;
			end += 10000;
			for (int j = 1; j <= page; j++) {
				try {
					StringBuilder urlBuilder = new StringBuilder(
							"http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /* URL */
					urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
							+ "=D21SdqOm7AojlfaqJFBST3lCQ27QgAqg0TW%2BP%2BDSCI3ZZghj9ZwBWiAh7StgwiTR8WwHIbhtYIto%2F8StRy4qVw%3D%3D");
					urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "="
							+ URLEncoder.encode(""+start+"", "UTF-8")); /* 유기날짜(검색 시작일) (YYYYMMDD) */
					urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "="
							+ URLEncoder.encode(""+end+"", "UTF-8")); /* 유기날짜(검색 종료일) (YYYYMMDD) */
//			          urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
//			          urlBuilder.append("&" + URLEncoder.encode("kind","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*품종코드 (품종 조회 OPEN API 참조)*/
//			          urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*시도코드 (시도 조회 OPEN API 참조)*/
//			          urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*시군구코드 (시군구 조회 OPEN API 참조)*/
//			          urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*보호소번호 (보호소 조회 OPEN API 참조)*/
//			          urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*상태(전체 : null(빈값), 공고중 : notice, 보호중 : protect)*/
//			          urlBuilder.append("&" + URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*상태 (전체 : null(빈값), 예 : Y, 아니오 : N, 미상 : U)*/
					urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
							+ URLEncoder.encode("" + j + "", "UTF-8")); /* 페이지 번호 (기본값 : 1) */
					urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
							+ URLEncoder.encode("1000", "UTF-8")); /* 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10 */
					urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
							+ URLEncoder.encode("json", "UTF-8")); /* xml(기본값) 또는 json */
					URL url = new URL(urlBuilder.toString());
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Content-type", "application/json");
					System.out.print((start/10000)+" ("+j+"/"+page+")");
					System.out.println(" Response code: " + conn.getResponseCode());
					BufferedReader br;
					if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
						br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					} else {
						br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
					}
					String line;
					String str = "";
					while ((line = br.readLine()) != null) {
						str += line + "\n";
					}
					List<DatasetDto> list = new ArrayList<>();
					try {
						JSONParser jsonParse = new JSONParser(); // JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
						JSONObject jsonObject = (JSONObject) jsonParse.parse(str);
						JSONObject response = (JSONObject) jsonObject.get("response");
						JSONObject body = (JSONObject) response.get("body");
						JSONObject items = (JSONObject) body.get("items");
						String totalCount = body.get("totalCount").toString();
						if(j == 1)
							System.out.println(totalCount);
						JSONArray item = (JSONArray) items.get("item"); // JSON 파싱 데이터에서 tracks부분을 배열로 가져옴
						for (int i = 0; i < item.size(); i++) {
							DatasetDto dto = new DatasetDto();
							JSONObject itembody = (JSONObject) item.get(i);
							dto.setDesertionNo(itembody.get("desertionNo").toString());
							dto.setFilename(itembody.get("filename").toString());
							dto.setHappenDt(itembody.get("happenDt").toString());
							dto.setHappenPlace(itembody.get("happenPlace").toString());
							dto.setKindCd(itembody.get("kindCd").toString());
							dto.setColorCd(itembody.get("colorCd") != null ? itembody.get("colorCd").toString() : "");
							dto.setAge(itembody.get("age").toString());
							dto.setWeight(itembody.get("weight").toString());
							dto.setNoticeNo(itembody.get("noticeNo") != null ? itembody.get("noticeNo").toString() : "");
							dto.setNoticeSdt(itembody.get("noticeSdt").toString());
							dto.setNoticeEdt(itembody.get("noticeEdt").toString());
							dto.setPopfile(itembody.get("popfile").toString());
							dto.setProcessState(itembody.get("processState") != null ? itembody.get("processState").toString() : "");
							dto.setSexCd(itembody.get("sexCd").toString());
							dto.setNeuterYn(itembody.get("neuterYn").toString());
							dto.setSpecialMark(itembody.get("specialMark") != null ? itembody.get("specialMark").toString() : "");
							dto.setCareNm(itembody.get("careNm").toString());
							dto.setCareTel(itembody.get("careTel").toString());
							dto.setCareAddr(itembody.get("careAddr").toString());
							dto.setOrgNm(itembody.get("orgNm").toString());
							dto.setChargeNm(itembody.get("chargeNm") != null ? itembody.get("chargeNm").toString() : "");
							dto.setOfficetel(itembody.get("officetel").toString());
//							System.out.println(dto);
							list.add(dto);
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					result += datasetDao.DataInsert(list);
					br.close();
					conn.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			ans += result;
			System.out.println((start/10000)+" 데이터베이스 결과 "+ result);
		}
		return ans;
	}

	@Override
	public int DataUpdate() {
		long s = System.currentTimeMillis();
		int result = 0;
		Date date = new Date();
		TimeZone timeZone;
		Calendar cal = Calendar.getInstance();
		timeZone = TimeZone.getTimeZone("Asia/Seoul");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		int end = Integer.parseInt(format.format(date));
		cal.setTime(date);
		cal.add(Calendar.MONTH, -4); // 4개월로 수정 필요
		int start = Integer.parseInt(format.format(cal.getTime()));
		int max = 1;
		
		for (int page = 1; page <= max; page++) {
			try {
				List<DatasetDto> list = new ArrayList<>();
				StringBuilder urlBuilder = new StringBuilder(
						"http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /* URL */
				urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
						+ "=D21SdqOm7AojlfaqJFBST3lCQ27QgAqg0TW%2BP%2BDSCI3ZZghj9ZwBWiAh7StgwiTR8WwHIbhtYIto%2F8StRy4qVw%3D%3D");
				urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "="
						+ URLEncoder.encode("" + start + "", "UTF-8")); /* 유기날짜(검색 시작일) (YYYYMMDD) */
				urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "="
						+ URLEncoder.encode("" + end + "", "UTF-8")); /* 유기날짜(검색 종료일) (YYYYMMDD) */
//	          urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
//	          urlBuilder.append("&" + URLEncoder.encode("kind","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*품종코드 (품종 조회 OPEN API 참조)*/
//	          urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*시도코드 (시도 조회 OPEN API 참조)*/
//	          urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*시군구코드 (시군구 조회 OPEN API 참조)*/
//	          urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*보호소번호 (보호소 조회 OPEN API 참조)*/
//	          urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*상태(전체 : null(빈값), 공고중 : notice, 보호중 : protect)*/
//	          urlBuilder.append("&" + URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*상태 (전체 : null(빈값), 예 : Y, 아니오 : N, 미상 : U)*/
				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
						+ URLEncoder.encode("" + page + "", "UTF-8")); /* 페이지 번호 (기본값 : 1) */
				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
						+ URLEncoder.encode("1000", "UTF-8")); /* 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10 */
				urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
						+ URLEncoder.encode("json", "UTF-8")); /* xml(기본값) 또는 json */
				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				System.out.println("Response code: " + conn.getResponseCode());
				BufferedReader br;
				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				String line;
				String str = "";
				while ((line = br.readLine()) != null) {
					str += line + "\n";
				}
				try {
					JSONParser jsonParse = new JSONParser(); // JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
					JSONObject jsonObject = (JSONObject) jsonParse.parse(str);
					JSONObject response = (JSONObject) jsonObject.get("response");
					JSONObject body = (JSONObject) response.get("body");
					JSONObject items = (JSONObject) body.get("items");
					int totalCount = Integer.parseInt(body.get("totalCount").toString());
					if (max == 1)
						max = totalCount % 1000 == 0 ? totalCount / 1000 : totalCount / 1000 + 1;
					JSONArray item = (JSONArray) items.get("item"); // JSON 파싱 데이터에서 tracks부분을 배열로 가져옴
					for (int i = 0; i < item.size(); i++) {
						DatasetDto dto = new DatasetDto();
						JSONObject itembody = (JSONObject) item.get(i);
						dto.setDesertionNo(itembody.get("desertionNo").toString());
						dto.setFilename(itembody.get("filename").toString());
						dto.setHappenDt(itembody.get("happenDt").toString());
						dto.setHappenPlace(itembody.get("happenPlace").toString());
						dto.setKindCd(itembody.get("kindCd").toString());
						dto.setColorCd(itembody.get("colorCd") != null ? itembody.get("colorCd").toString() : "");
						dto.setAge(itembody.get("age").toString());
						dto.setWeight(itembody.get("weight").toString());
						dto.setNoticeNo(itembody.get("noticeNo") != null ? itembody.get("noticeNo").toString() : "");
						dto.setNoticeSdt(itembody.get("noticeSdt").toString());
						dto.setNoticeEdt(itembody.get("noticeEdt").toString());
						dto.setPopfile(itembody.get("popfile").toString());
						dto.setProcessState(itembody.get("processState") != null ? itembody.get("processState").toString() : "");
						dto.setSexCd(itembody.get("sexCd").toString());
						dto.setNeuterYn(itembody.get("neuterYn").toString());
						dto.setSpecialMark(itembody.get("specialMark") != null ? itembody.get("specialMark").toString() : "");
						dto.setCareNm(itembody.get("careNm").toString());
						dto.setCareTel(itembody.get("careTel").toString());
						dto.setCareAddr(itembody.get("careAddr").toString());
						dto.setOrgNm(itembody.get("orgNm").toString());
						dto.setChargeNm(itembody.get("chargeNm") != null ? itembody.get("chargeNm").toString() : "");
						dto.setOfficetel(itembody.get("officetel").toString());
						list.add(dto);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				result += datasetDao.DataInsert(list);
				System.out.println(result);
				br.close();
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		long e = System.currentTimeMillis();
		System.out.println("실행시간 : " + ((e - s)/1000.0));
		return result;
	}

//	@Override
//	public int CsvMake(Map<String, String> map) {
//		long s = System.currentTimeMillis();
//		String[] gugun = new String[] {"인천광역시","서울특별시","경기도","강원도","세종특별자치시","대전광역시","충청남도","충청북도","경상북도","대구광역시","울산광역시","경상남도","부산광역시","전라북도","전라남도","광주광역시","제주특별자치도"};
//		String[] sex = new String[] {"F","Q","M"};
//		String[] color = new String[] {"흰","힌","휜","하","화","백","white","베","아이","황","크림","노","누","골","금","gold","붉","빨","분","커피","브라","갈","밤","쵸","초코","초콜","초","녹","실버","그","회","감장","흑","블","검","black","바둑","젖소","점박","얼룩","삼색","호피","블루","고","치즈","턱시","코숏"};
//		Date date = new Date();
//		TimeZone timeZone;
//		Calendar cal = Calendar.getInstance();
//		timeZone = TimeZone.getTimeZone("Asia/Seoul");
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//		int end = Integer.parseInt(format.format(date));
//		cal.setTime(date);
//		cal.add(Calendar.MONTH, -4); // 4개월로 수정 필요
//		int start = Integer.parseInt(format.format(cal.getTime()));
//		int max = 1;
//		List<DatasetDto> list = new ArrayList<>();
//		for (int page = 1; page <= max; page++) {
//			try {
//				StringBuilder urlBuilder = new StringBuilder(
//						"http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /* URL */
//				urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
//						+ "=D21SdqOm7AojlfaqJFBST3lCQ27QgAqg0TW%2BP%2BDSCI3ZZghj9ZwBWiAh7StgwiTR8WwHIbhtYIto%2F8StRy4qVw%3D%3D");
//				urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "="
//						+ URLEncoder.encode("" + start + "", "UTF-8")); /* 유기날짜(검색 시작일) (YYYYMMDD) */
//				urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "="
//						+ URLEncoder.encode("" + end + "", "UTF-8")); /* 유기날짜(검색 종료일) (YYYYMMDD) */
////	          urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
////	          urlBuilder.append("&" + URLEncoder.encode("kind","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*품종코드 (품종 조회 OPEN API 참조)*/
////	          urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*시도코드 (시도 조회 OPEN API 참조)*/
////	          urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*시군구코드 (시군구 조회 OPEN API 참조)*/
////	          urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*보호소번호 (보호소 조회 OPEN API 참조)*/
////	          urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*상태(전체 : null(빈값), 공고중 : notice, 보호중 : protect)*/
////	          urlBuilder.append("&" + URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode(" ", "UTF-8")); /*상태 (전체 : null(빈값), 예 : Y, 아니오 : N, 미상 : U)*/
//				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
//						+ URLEncoder.encode("" + page + "", "UTF-8")); /* 페이지 번호 (기본값 : 1) */
//				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
//						+ URLEncoder.encode("1000", "UTF-8")); /* 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10 */
//				urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
//						+ URLEncoder.encode("json", "UTF-8")); /* xml(기본값) 또는 json */
//				URL url = new URL(urlBuilder.toString());
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.setRequestProperty("Content-type", "application/json");
//				System.out.println("Response code: " + conn.getResponseCode());
//				BufferedReader br;
//				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//					br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				} else {
//					br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//				}
//				String line;
//				String str = "";
//				while ((line = br.readLine()) != null) {
//					str += line + "\n";
//				}
//				try {
//					JSONParser jsonParse = new JSONParser(); // JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
//					JSONObject jsonObject = (JSONObject) jsonParse.parse(str);
//					JSONObject response = (JSONObject) jsonObject.get("response");
//					JSONObject body = (JSONObject) response.get("body");
//					JSONObject items = (JSONObject) body.get("items");
//					int totalCount = Integer.parseInt(body.get("totalCount").toString());
//					if (max == 1)
//						max = totalCount % 1000 == 0 ? totalCount / 1000 : totalCount / 1000 + 1;
//					JSONArray item = (JSONArray) items.get("item"); // JSON 파싱 데이터에서 tracks부분을 배열로 가져옴
//					for (int i = 0; i < item.size(); i++) {
//						DatasetDto dto = new DatasetDto();
//						JSONObject itembody = (JSONObject) item.get(i);
////						if(!itembody.get("kindCd").toString().contains(map.get("kindCd")))
////							continue;
//						dto.setDesertionNo(itembody.get("desertionNo").toString());
//						dto.setFilename(itembody.get("filename").toString());
//						dto.setHappenDt(itembody.get("happenDt").toString());
//						dto.setHappenPlace(itembody.get("happenPlace").toString());
//						dto.setKindCd(itembody.get("kindCd").toString());
//						if(itembody.get("colorCd") != null) {
//							for (int j = 0; j < color.length; j++) {
//								if(itembody.get("colorCd").toString().contains(color[j])) {
//									dto.setColorCd(j+"");
//									break;
//								}
//								if(j == color.length -1)
//									dto.setColorCd(color.length+"");
//							}
//						}else {
//							dto.setColorCd("-");
//						}
//						dto.setAge(itembody.get("age").toString());
//						dto.setWeight(itembody.get("weight").toString());
//						dto.setNoticeNo(itembody.get("noticeNo") != null ? itembody.get("noticeNo").toString() : "-");
//						dto.setNoticeSdt(itembody.get("noticeSdt").toString());
//						dto.setNoticeEdt(itembody.get("noticeEdt").toString());
//						dto.setPopfile(itembody.get("popfile").toString());
//						dto.setProcessState(itembody.get("processState") != null ? itembody.get("processState").toString() : "-");
//						for (int j = 0; j < sex.length; j++) {
//							if(itembody.get("sexCd").toString().contains(sex[j])) {
//								dto.setSexCd(j+"");
//								break;
//							}
//						}
//						dto.setNeuterYn(itembody.get("neuterYn").toString());
//						dto.setSpecialMark(itembody.get("specialMark") != null ? itembody.get("specialMark").toString() : "-");
//						dto.setCareNm(itembody.get("careNm").toString());
//						dto.setCareTel(itembody.get("careTel").toString());
//						dto.setCareAddr(itembody.get("careAddr").toString());
//						for (int j = 0; j < gugun.length; j++) {
//							if(itembody.get("orgNm").toString().contains(gugun[j])) {
//								dto.setOrgNm(j+"");
//								break;
//							}
//						}
//						dto.setChargeNm(itembody.get("chargeNm") != null ? itembody.get("chargeNm").toString() : "-");
//						dto.setOfficetel(itembody.get("officetel").toString());
//						list.add(dto);
//					}
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				br.close();
//				conn.disconnect();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		File csv = new File("src/main/resources/recommend.csv");
//		BufferedWriter bw = null; // 출력 스트림 생성
//        try {
//            bw = new BufferedWriter(new FileWriter(csv));
//            // csv파일의 기존 값에 이어쓰려면 위처럼 true를 지정하고, 기존 값을 덮어쓰려면 true를 삭제한다
////            String col = "desertionNo|filename|happenDt|happenPlace|kindCd|colorCd|age|weight|noticeNo|noticeSdt|noticeEdt|popfile|processState|sexCd|neuterYn|specialMark|careNm|careTel|careAddr|orgNm|chargeNm|officetel";
////            bw.write(col);
//			// 작성한 데이터를 파일에 넣는다
////			bw.newLine(); // 개행
//            for (DatasetDto dto : list) {
//				String str = "";
//				str = dto.getDesertionNo() +"|" + dto.getFilename() + "|" + dto.getHappenDt() +"|" +dto.getHappenPlace()+"|"+
//						dto.getKindCd() +"|"+ dto.getColorCd()+"|"+dto.getAge()+"|"+dto.getWeight()+"|"+dto.getNoticeNo()+"|"+
//						dto.getNoticeSdt()+"|"+dto.getNoticeEdt()+"|"+dto.getPopfile()+"|"+dto.getProcessState()+"|"+dto.getSexCd()+"|"+
//						dto.getNeuterYn()+"|"+dto.getSpecialMark()+"|"+dto.getCareNm()+"|"+dto.getCareTel()+"|"+dto.getCareAddr()+"|"+
//						dto.getOrgNm()+"|"+dto.getChargeNm()+"|"+dto.getOfficetel();
//				// 한 줄에 넣을 각 데이터 사이에 ,를 넣는다
//				bw.write(str);
//				// 작성한 데이터를 파일에 넣는다
//				bw.newLine(); // 개행
//			}
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bw != null) {
//                    bw.flush(); // 남아있는 데이터까지 보내 준다
//                    bw.close(); // 사용한 BufferedWriter를 닫아 준다
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//		long e = System.currentTimeMillis();
//		System.out.println("실행시간 : " + ((e - s)/1000.0));
//		return list.size();
//	}
}
