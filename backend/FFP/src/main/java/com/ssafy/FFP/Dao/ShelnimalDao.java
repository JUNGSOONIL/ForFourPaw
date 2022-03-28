package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShelnimalDao {

    public ShelnimalDto select(int no);
    public List<ShelnimalDto> list(int sdt);
    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
}
