package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dao.CommentDao;
import com.ssafy.FFP.Dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Override
    public int create(CommentDto commentDto) {
        commentDao.create(commentDto);
        int result = commentDao.relation(commentDto.getNo(), commentDto.getMissNo());
        return result;
    }

    @Override
    public int delete(int no) {
        int result = commentDao.delete(no);
        return result;
    }

    @Override
    public List<CommentDto> list(int missNo) {
        List<CommentDto> commentDtos = commentDao.list(missNo);
        return commentDtos;
    }

    @Override
    public CommentDto select(int no) {
        CommentDto commentDto = commentDao.select(no);
        return commentDto;
    }
}
