package com.ssafy.FFP.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.FFP.Dto.DatasetDto;

@Mapper
public interface MissMatchDao {
	public List<DatasetDto> DataSelect(Map<String, String> map);
}
