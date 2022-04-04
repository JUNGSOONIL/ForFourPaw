package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MissnimalDao {

    public MissnimalDto select(int no);
    public List<MissnimalDto> selectByUser(int no);
    public int create(MissnimalDto missnimalDto);
    public int update(MissnimalDto missnimalDto);
    public int delete(int no);
    public List<MissnimalDto> list(@Param("offset") int offset,
                                   @Param("limit") int limit);
    public List<MissnimalDto> match(int userNo);
    public List<MissnimalDto> find(SearchDto searchDto);

    public int relation(
            @Param("imgNo") int imgNo,
            @Param("missNo") int missNo);
}