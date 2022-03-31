package com.ssafy.FFP.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.FFP.Dto.DatasetDto;

@Mapper
public interface DatasetDao {
	public int DataInsert(List<DatasetDto> dto);
	public int DataUpdate(List<DatasetDto> dto);
}
