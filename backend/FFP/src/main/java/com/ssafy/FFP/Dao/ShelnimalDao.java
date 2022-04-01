package com.ssafy.FFP.Dao;

import java.util.List;

import com.ssafy.FFP.Dto.MissnimalDto;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShelnimalDao {

    public ShelnimalDto select(int no);
    public List<ShelnimalDto> list(@Param("sdt") int sdt,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);
    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
    public List<DatasetDto> mainList(String processState);
    public List<String> searchList(String kind);
}
