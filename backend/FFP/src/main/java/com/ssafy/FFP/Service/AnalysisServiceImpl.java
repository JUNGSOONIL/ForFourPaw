package com.ssafy.FFP.Service;


import com.ssafy.FFP.Dao.AnalysisDao;
import com.ssafy.FFP.Dto.AnalysisDto;
import com.ssafy.FFP.Dto.AnalysisResultDto;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map.Entry;
import java.util.*;

import static org.apache.spark.sql.functions.*;

@Service
public class AnalysisServiceImpl implements  AnalysisService {

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    static long[] valuearr;
    static HashMap<String, Long > HM;
    static List<AnalysisDto> list;

    @Autowired
    AnalysisDao analysisDao;

    // DB에서 불러오기
    @Override
    public AnalysisResultDto loaddata() {
        System.out.println("[system] load data from DB");
        // 리턴 결과
        AnalysisResultDto result = new AnalysisResultDto();
        result.setNumber(19961105);

        //001 무게 별
        List<AnalysisDto> templist = analysisDao.chartlist("001");
        result.setList(templist);

        //002 월별
        templist = analysisDao.chartlist("002");
        result.setDatelist(templist);

        //003 개 고양이 기타 분류
        templist = analysisDao.chartlist("003");
        result.setKindlist(templist);
        //
        //004 품종워드클라우드
        templist = analysisDao.chartlist("004");
        result.setKindlist2(templist);

        //005 지역별
        templist = analysisDao.chartlist("005");
        result.setRegionlist(templist);

        //006 연도별
        templist = analysisDao.chartlist("006");
        result.setYearlist(templist);

        return result;
    }

    @Override
    public void updateChartDB() {

        // 테이블 비우기 먼저
        analysisDao.cleartable();

        // 스파크
        System.out.println("[System] Spark 데이터 분석");

        SparkSession spark = SparkSession.builder()
                .appName("simple app")
                .config("spark.master", "local")
                .getOrCreate();

        String url =  "jdbc:mysql://3.38.149.72:3306/ffp?serverTimezone=Asia/Seoul";
        Dataset<Row> df = spark
                .read()
                .format("jdbc")
                .option("driver", "com.mysql.jdbc.Driver")
                .option("url", url)
                .option("user", "FFP")
                .option("password", "ffp1234!")
                .option("dbtable", "dataset")
                .load();

        // 001 : 무게
        System.out.println("[System] 데이터 전처리 실행 ");
        Dataset<Row> re = df
                .select( regexp_replace( col("weight"), "[(]Kg[)]| |[^0-9|.]|[0-9]+[.][(0-9)]+[.][0-9]+[(]Kg[)]", "").alias("holy"), col("weight"))
                .select( regexp_replace( col("holy"), "[0-9]+[.][(0-9)]+[.][0-9]*", "").alias("weightre"), col("holy") )
                .groupBy("weightre")
                .count();
        re.show();

        valuearr = new long[11];
        re.foreach( now -> {
            // 변수 타입은 String
            String temp = (String) now.get(0);
            if (
                    temp != null
                            && temp.equals("") == false
                            && temp.contains("..") == false
                            && temp.charAt(0) != '.'
            ){
                Double num = Double.parseDouble(temp);
                if ( 0 <= num && num < 1){
                    valuearr[0] += (long) now.get(1);
                } else if ( 1 <= num && num < 2 ){
                    valuearr[1] +=  (long) now.get(1);
                } else if ( 2 <= num && num < 3 ){
                    valuearr[2] +=  (long) now.get(1);
                } else if ( 3 <= num && num < 4 ){
                    valuearr[3] +=  (long) now.get(1);
                } else if ( 4 <= num && num < 5 ){
                    valuearr[4] +=  (long) now.get(1);
                } else if ( 5 <= num && num < 6 ){
                    valuearr[5] +=  (long) now.get(1);
                } else if ( 6 <= num && num < 7 ){
                    valuearr[6] +=  (long) now.get(1);
                } else if ( 7 <= num && num < 8 ){
                    valuearr[7] +=  (long)now.get(1);
                } else if ( 8 <= num && num < 9 ){
                    valuearr[8] +=  (long) now.get(1);
                } else if ( 9 <= num && num < 10 ){
                    valuearr[9] += (long)now.get(1);
                } else if ( 10 <= num ){
                    valuearr[10] += (long)now.get(1);
                }
            }
        });


        // 무게 코드 001
        for (int i = 0 ; i <= 10; i++ ){
            AnalysisDto dto = new AnalysisDto( Integer.toString(i), valuearr[i], "001");
            int weight_rs = analysisDao.Insert(dto);
        }

//         날짜 분류 코드
        Dataset<Row> date_re = df
                .select( regexp_replace( col("happenDt"), "20[0-9]{2}|[^0-9]", "").alias("date"), col("happenDt"))
                .groupBy("date")
                .count();
//        date_re.show();

        valuearr = new long[12];
        date_re.foreach( now -> {
            String temp = (String) now.get(0);
            int month = Integer.parseInt(temp.substring(0,2));
//            long monthvalue = Long.parseLong( (String) now.get(1) );
            if ( month <= 12){
                valuearr[month-1] += (long) now.get(1);
            }
        });
        // 결과 출력
        System.out.println("월별 통계");
        for (int i = 0 ; i < 12; i++ ){
            AnalysisDto dto = new AnalysisDto( Integer.toString(i), valuearr[i], "002");
            int weight_rs = analysisDao.Insert(dto);
        }


//         풍종 분류
        System.out.println("[system] 품종 별로 분류");
        re  = df
                .select( regexp_replace( col("kindCd"), "(?!개|고|기).|", "").alias("kind"), col("kindCd"))
                .groupBy("kind")
                .count();
        re.show(30);
        valuearr = new long[3];
        re.foreach( now -> {
            String temp = (String) now.get(0);
            if ( temp.length() >= 1 ){
                if ( temp.charAt(0) == '개' ) {
                    valuearr[0] += (long) now.get(1);
                } else if ( temp.charAt(0) == '고' ) {
                    valuearr[1] += (long) now.get(1);
                } else if ( temp.charAt(0) == '기' ) {
                    valuearr[2] += (long) now.get(1);
                }
            }
        });
        System.out.println("동물 별 통계");
        System.out.println(Arrays.toString(valuearr));
        for (int i = 0 ; i < valuearr.length ; i++ ){
            AnalysisDto dto = new AnalysisDto( Integer.toString(i), valuearr[i], "003");
            int weight_rs = analysisDao.Insert(dto);
        }

        // 품종 분류2
        System.out.println("[system] 품종 별로 분류 2");
        re  = df
                .select( regexp_replace( col("kindCd"), "\\[개\\]|\\[고양이\\]|\\[기타축종\\]|[^가-힣]", "").alias("kind"), col("kindCd"))
                .groupBy("kind")
                .count();
        re = re.orderBy(desc("count"));

        System.out.println("품종별 통계");
        re.show(200);
        HM = new HashMap<String,Long>();

        re.foreach( now -> {
            String temp = (String) now.get(0);
            long value = (long) now.get(1);
            if ( value >= 20 ){
                if ( temp.length() < 1 ||temp.equals("길고양이") || temp.equals("믹스묘") || temp.equals("고양이") || temp.equals("코숏") || temp.equals("혼합") || temp.equals("한국고양이") ){
                    temp = "코숏";
                } else if ( temp.equals("혼종") || temp.equals("발바리")
                        || temp.equals("mix") || temp.equals("믹스") || temp.equals("혼합종") || temp.equals("잡견")
                        || temp.equals("믹스견") || temp.equals("잡종") || temp.equals("강아지") || temp.equals("잡종견") ) {
                    temp = "믹스";
                }
                // 데이터에 넣기
                HM.put(temp, HM.getOrDefault(temp, (long) 0) + value);
            }
        });

        for ( Map.Entry<String, Long> entry : HM.entrySet()) {
//            if ( entry.getValue() > 80 )
            AnalysisDto dto = new AnalysisDto( entry.getKey(), entry.getValue() , "004");
            int weight_rs = analysisDao.Insert(dto);
        }

        // 지역 통계
        System.out.println("[system] 지역 통계");
        re  = df
                .select( regexp_replace( col("orgNm"), "(?<=도|시)[ 가-힣]+", "").alias("region"), col("orgNm"))
                .groupBy("region")
                .count();
        re = re.orderBy(desc("count"));

        list = new ArrayList<AnalysisDto>();

        re.foreach( now -> {
            String temp = (String) now.get(0);
            long value = (long) now.get(1);
            if ( value >= 10 ) {
                list.add(new AnalysisDto(temp,value));
            }
        });

        for(AnalysisDto temp : list ){
            temp.setCode("005");
            int weight_rs = analysisDao.Insert(temp);
        }

        // 연도 통계
        System.out.println("[system] 연도 통계");
        df.createOrReplaceTempView("animal");
        Dataset<Row> sqlDF = spark.sql(" " +
                " SELECT substring(noticeSdt, 1, 4) AS y, COUNT(substring(noticeSdt, 1, 4)) AS COUNT" +
                " FROM animal " +
                " GROUP BY y " +
                " ORDER BY y; ");
//        sqlDF.show();

        list = new ArrayList<AnalysisDto>();
        sqlDF.foreach( now -> {
            if ( 30 <= (long) now.get(1) ) {
                list.add(new AnalysisDto( (String) now.get(0), (long) now.get(1) ));
            }
        });
        for(AnalysisDto temp : list ){
            temp.setCode("006");
            int weight_rs = analysisDao.Insert(temp);
        }

        System.out.println("[system] data 업데이트 완료!");
    }

}
