package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MissnimalDao {

    public MissnimalDto select(int no);
    public int create(MissnimalDto missnimalDto);
    public int update(MissnimalDto missnimalDto);
    public int delete(int no);
    public List<MissnimalDto> list(String sdt);
    public List<MissnimalDto> match(int userNo);
    public List<MissnimalDto> find(SearchDto searchDto);
}
