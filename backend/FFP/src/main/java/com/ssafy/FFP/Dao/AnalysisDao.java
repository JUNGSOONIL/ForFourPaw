package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.AnalysisDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnalysisDao {

    public int test();
    // 데이터 결과 넣기
    public int I_weight_list(List<AnalysisDto> list);
    public int I_weight(AnalysisDto dto);
    public int Insert(AnalysisDto dto);

    // DB에서 불러오기
    public List<AnalysisDto> chartlist(String code);

    // DB 테이블 초기화
    public void cleartable();


}
