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

import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.FFP.Dao.DatasetDao;
import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.MonthDto;

@Service
public class DatasetServiceImpl implements DatasetService {

	@Autowired
	DatasetDao datasetDao;
	
	@Override
	public void DataAdd() {
		int totalCount = 0;
		Date date = new Date();
		TimeZone timeZone;
		timeZone = TimeZone.getTimeZone("Asia/Seoul");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		int end = Integer.parseInt(format.format(date));
		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "=D21SdqOm7AojlfaqJFBST3lCQ27QgAqg0TW%2BP%2BDSCI3ZZghj9ZwBWiAh7StgwiTR8WwHIbhtYIto%2F8StRy4qVw%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "="
					+ URLEncoder.encode(""+end+"", "UTF-8")); /* 유기날짜(검색 시작일) (YYYYMMDD) */
			urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "="
					+ URLEncoder.encode(""+end+"", "UTF-8")); /* 유기날짜(검색 종료일) (YYYYMMDD) */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("1000", "UTF-8")); /* 페이지당 보여줄 개수 (1,000 이하), 기본값 : 10 */
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
					+ URLEncoder.encode("json", "UTF-8")); /* xml(기본값) 또는 json */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println(" Response code: " + conn.getResponseCode());
			BufferedReader br;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				return;
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
				totalCount = Integer.parseInt(body.get("totalCount").toString());
				br.close();
				conn.disconnect();
				JSONArray item = (JSONArray) items.get("item"); // JSON 파싱 데이터에서 tracks부분을 배열로 가져옴
				for (int i = 0; i < item.size(); i++) {
					DatasetDto dto = new DatasetDto();
					JSONObject itembody = (JSONObject) item.get(i);
					dto.setDesertionNo(itembody.get("desertionNo") != null ? itembody.get("desertionNo").toString() : "-");
					dto.setFilename(itembody.get("filename") != null ? itembody.get("filename").toString() : "-");
					dto.setHappenDt(itembody.get("happenDt") != null ? itembody.get("happenDt").toString() : "-");
					dto.setHappenPlace(itembody.get("happenPlace") != null ? itembody.get("happenPlace").toString() : "-");
					dto.setKindCd(itembody.get("kindCd") != null ? itembody.get("kindCd").toString() : "-");
					dto.setColorCd(itembody.get("colorCd") != null ? itembody.get("colorCd").toString() : "-");
					dto.setAge(itembody.get("age") != null ? itembody.get("age").toString() : "-");
					dto.setWeight(itembody.get("weight") != null ? itembody.get("weight").toString() : "-");
					dto.setNoticeNo(itembody.get("noticeNo") != null ? itembody.get("noticeNo").toString() : "-");
					dto.setNoticeSdt(itembody.get("noticeSdt") != null ? itembody.get("noticeSdt").toString() : "-");
					dto.setNoticeEdt(itembody.get("noticeEdt") !=null ? itembody.get("noticeEdt").toString() : "-");
					dto.setPopfile(itembody.get("popfile") != null ? itembody.get("popfile").toString() : "-");
					dto.setProcessState(itembody.get("processState") != null ? itembody.get("processState").toString() : "-");
					dto.setSexCd(itembody.get("sexCd") != null ? itembody.get("sexCd").toString() : "-");
					dto.setNeuterYn(itembody.get("neuterYn") != null ? itembody.get("neuterYn").toString() : "-");
					dto.setSpecialMark(itembody.get("specialMark") != null ? itembody.get("specialMark").toString() : "-");
					dto.setCareNm(itembody.get("careNm") != null ? itembody.get("careNm").toString() : "-");
					dto.setCareTel(itembody.get("careTel") != null ? itembody.get("careTel").toString() : "-");
					dto.setCareAddr(itembody.get("careAddr") != null ? itembody.get("careAddr").toString() : "-");
					dto.setOrgNm(itembody.get("orgNm") != null ? itembody.get("orgNm").toString() : "-");
					dto.setChargeNm(itembody.get("chargeNm") != null ? itembody.get("chargeNm").toString() : "-");
					dto.setOfficetel(itembody.get("officetel") != null ? itembody.get("officetel").toString() : "-");
					list.add(dto);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Integer cnt = datasetDao.DataSelect(end);
			if(cnt == null || cnt < totalCount) {
				datasetDao.DataUpdate(list);
				datasetDao.TodayInsert(end, totalCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, Integer> DataSelect() {
		Date date = new Date();
		TimeZone timeZone;
		timeZone = TimeZone.getTimeZone("Asia/Seoul");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		int end = Integer.parseInt(format.format(date));
		Map<String, Integer> map = new HashedMap<String, Integer>();
		Integer cnt = datasetDao.DataSelect(end);
		List<MonthDto> Protect = datasetDao.MonthProtect();
		map.put("today", cnt == null ? 0 : cnt);
		map.put("protect", Protect.get(0).getCount());
		map.put("return", Protect.get(1).getCount() + Protect.get(3).getCount() +Protect.get(6).getCount());
		map.put("death", Protect.get(5).getCount() +Protect.get(7).getCount());
		return map;
	}

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
					return -1;
				}
				String line;
				String str = "";
				while ((line = br.readLine()) != null) {
					str += line + "\n";
				}
				try {
					if(str.contains("SERVICE ERROR"))
						return -1;
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
						dto.setDesertionNo(itembody.get("desertionNo") != null ? itembody.get("desertionNo").toString() : "-");
						dto.setFilename(itembody.get("filename") != null ? itembody.get("filename").toString() : "-");
						dto.setHappenDt(itembody.get("happenDt") != null ? itembody.get("happenDt").toString() : "-");
						dto.setHappenPlace(itembody.get("happenPlace") != null ? itembody.get("happenPlace").toString() : "-");
						dto.setKindCd(itembody.get("kindCd") != null ? itembody.get("kindCd").toString() : "-");
						dto.setColorCd(itembody.get("colorCd") != null ? itembody.get("colorCd").toString() : "-");
						dto.setAge(itembody.get("age") != null ? itembody.get("age").toString() : "-");
						dto.setWeight(itembody.get("weight") != null ? itembody.get("weight").toString() : "-");
						dto.setNoticeNo(itembody.get("noticeNo") != null ? itembody.get("noticeNo").toString() : "-");
						dto.setNoticeSdt(itembody.get("noticeSdt") != null ? itembody.get("noticeSdt").toString() : "-");
						dto.setNoticeEdt(itembody.get("noticeEdt") !=null ? itembody.get("noticeEdt").toString() : "-");
						dto.setPopfile(itembody.get("popfile") != null ? itembody.get("popfile").toString() : "-");
						dto.setProcessState(itembody.get("processState") != null ? itembody.get("processState").toString() : "-");
						dto.setSexCd(itembody.get("sexCd") != null ? itembody.get("sexCd").toString() : "-");
						dto.setNeuterYn(itembody.get("neuterYn") != null ? itembody.get("neuterYn").toString() : "-");
						dto.setSpecialMark(itembody.get("specialMark") != null ? itembody.get("specialMark").toString() : "-");
						dto.setCareNm(itembody.get("careNm") != null ? itembody.get("careNm").toString() : "-");
						dto.setCareTel(itembody.get("careTel") != null ? itembody.get("careTel").toString() : "-");
						dto.setCareAddr(itembody.get("careAddr") != null ? itembody.get("careAddr").toString() : "-");
						dto.setOrgNm(itembody.get("orgNm") != null ? itembody.get("orgNm").toString() : "-");
						dto.setChargeNm(itembody.get("chargeNm") != null ? itembody.get("chargeNm").toString() : "-");
						dto.setOfficetel(itembody.get("officetel") != null ? itembody.get("officetel").toString() : "-");
						list.add(dto);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				result += datasetDao.DataUpdate(list);
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
}
