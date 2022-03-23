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
        int result = commentDao.create(commentDto);
        return result;
    }

    @Override
    public int delete(int no) {
        int result = commentDao.delete(no);
        return result;
    }

    @Override
    public int relation(int commentNo, int feedNo) {
        int result = commentDao.relation(commentNo, feedNo);
        return result;
    }

    @Override
    public List<CommentDto> list(int postNo) {
        List<CommentDto> commentDtos = commentDao.list(postNo);
        return commentDtos;
    }

    @Override
    public CommentDto select(int no) {
        CommentDto commentDto = commentDao.select(no);
        return commentDto;
    }
}
