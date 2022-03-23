package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Dto.CommentDto;
import com.ssafy.FFP.Dto.UserDto;
import com.ssafy.FFP.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    private static final int SUCCESS = 1;

    @PostMapping(value = "/comments") // 회원가입
    public ResponseEntity<Integer> create(@RequestBody CommentDto commentDto) {

        if (commentService.create(commentDto) == SUCCESS) {


            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            System.out.println("댓글 작성 실패");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "양식이 올바르지 않습니다.");
        }
    }


}
