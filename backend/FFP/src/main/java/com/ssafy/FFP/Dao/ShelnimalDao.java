package com.ssafy.FFP.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;

@Mapper
public interface ShelnimalDao {

    public ShelnimalDto select(int no);
    public List<ShelnimalDto> list(int sdt);
    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
    public List<DatasetDto> mainList(String processState);
    public List<String> searchList(String kind);
}
