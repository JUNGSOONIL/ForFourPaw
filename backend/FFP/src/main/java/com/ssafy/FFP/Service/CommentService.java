package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dto.CommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    public int create(CommentDto commentDto);

    public int delete(int no);

    public List<CommentDto> list(int postNo);

    public CommentDto select(int no);

}
