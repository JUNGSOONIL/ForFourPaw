package com.ssafy.FFP.Service;


import com.ssafy.FFP.Dto.AnalysisDto;
import com.ssafy.FFP.Dto.AnalysisResultDto;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.regexp_replace;

@Service
public class AnalysisServiceImpl implements  AnalysisService {


    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    static long[] valuearr;

    @Override
    public AnalysisResultDto test() {
        AnalysisResultDto result = new AnalysisResultDto();

        result.setNumber(486);

        System.out.println("스파크테스트");
        String logFile = "src/main/resources/data/dataset.csv";

//        SparkSession spark = SparkSession.builder().appName("simple app").config("spark.master", "local").getOrCreate();
//
//        Dataset<Row> logData = spark.read().csv(logFile);
//        logData.show();

        SparkSession spark = SparkSession.builder()
                .appName("simple app")
                .config("spark.master", "local")
                .getOrCreate();

        Dataset<Row> df = spark.read().option("delimiter", ";").option("header", "true").option("encoding", "euc-kr").csv(logFile);
        //Dataset<Row> df = spark.read().csv(logFile);

//        Dataset<Row> re  = df.groupBy("weight").count();
//        Dataset<Row> re  = df.select("weight");
//        .select(col("Description"),
//                lower(col("Description")),
//                upper(lower(col("Description"))))
//                .show(2)
////
//        df.withColumn('year', substring('date', 1,4))\
//    .withColumn('month', substring('date', 5,2))\
//    .withColumn('day', substring('date', 7,2))

//        df.select(col("a"), substring_index(col("a"), ",", 1).as("b"));

        System.out.println("결과 출력");

        // substring 사용
//        df.withColumn("test", substring( col("weight"),0,-1 )).select("test").show();
        // 무게별로 카운트 해버리기
//        re.show(30);

        // SQL 활용용
//        df.createOrReplaceTempView("animal");
//        Dataset<Row> sqlDF = spark.sql("SELECT * FROM animal LIMIT 3");
//        sqlDF.show();

        // 정규식

//        val simpleColors = Seq("black", "white", "red", "green", "blue")
//        val regexString = simpleColors.map(_.toUpperCase).mkString("|")

        Dataset<Row> re = df
//                .select( regexp_replace( col("weight"), "[(]Kg[)]", "").alias("holyshit"), col("weight"))
                .select( regexp_replace( col("weight"), "[(]Kg[)]| |[^0-9|.]|[0-9]+[.][(0-9)]+[.][0-9]+[(]Kg[)]", "").alias("holyshit"), col("weight"))
                .select( regexp_replace( col("holyshit"), "[0-9]+[.][(0-9)]+[.][0-9]*", "").alias("holyshit2"), col("holyshit") )
                .groupBy("holyshit2")
                .count();
        re.show();
//        re.foreach((ForeachFunction<Row>) row ->
//                {
//                    row.
//                    System.out.println(row);
//                }
//        );

        System.out.println("foreach사용해보기");

        valuearr = new long[11];

        re.foreach( now -> {
            // 변수 타입은 String
//            System.out.print( "무게 : " + now.get(0) );
//            System.out.println( " 수 : " + now.get(1) );

//            String temp = now.get(0) + " >>>> " + now.get(1);
            String temp = (String) now.get(0);
            if (
                    temp != null
                            && temp.equals("") == false
                            && temp.contains("..") == false
                            && temp.charAt(0) != '.'
            ){
//                    System.out.print(temp + " >>> ");
                Double num = Double.parseDouble(temp);
//                    System.out.println( num );
//                    System.out.println( (long) now.get(1) + 1000000 );
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
//                System.out.println(Arrays.toString(valuearr));
            }
        });


        System.out.println(Arrays.toString(valuearr));

        List<AnalysisDto> result_list = new ArrayList<AnalysisDto>();
        for (int i = 0 ; i <= 10; i++ ){
            result_list.add( new AnalysisDto( Integer.toString(i), valuearr[i] ));
            System.out.println(result_list.get(i).toString());
        }
        result.setList(result_list);

        // 여기서 실행
        return result;
    }

}
