package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {

    public int create(CommentDto commentDto);

    public int delete(int no);

    public List<CommentDto> list(int postNo);

    public CommentDto select(int no);

    public int relation(
            @Param("commentNo") int commentNo,
            @Param("missNo") int missNo);

}
