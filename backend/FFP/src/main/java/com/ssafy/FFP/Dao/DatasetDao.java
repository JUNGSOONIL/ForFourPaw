package com.ssafy.FFP.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.MonthDto;

@Mapper
public interface DatasetDao {
	public int DataInsert(List<DatasetDto> dto);
	public int DataUpdate(List<DatasetDto> dto);
	public Integer DataSelect(int date);
	public int TodayInsert(@Param("date") int date,@Param("cnt") int cnt);
	public List<MonthDto> MonthProtect();
}
