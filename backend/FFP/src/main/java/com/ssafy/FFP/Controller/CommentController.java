package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Dto.CommentDto;
import com.ssafy.FFP.Dto.UserDto;
import com.ssafy.FFP.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    private static final int SUCCESS = 1;

    @PostMapping(value = "/comments") // 댓글 작성
    public ResponseEntity<Integer> create(@RequestBody CommentDto commentDto) {

        if (commentService.create(commentDto) == SUCCESS) {
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            System.out.println("댓글 작성 실패");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "양식이 올바르지 않습니다.");
        }
    }

    @GetMapping(value = "/comment/{no}") // 댓글 조회
    public ResponseEntity<?> select(@PathVariable String no) {

        int commentNo = Integer.parseInt(no);
        CommentDto commentDto = commentService.select(commentNo);

        if(commentDto != null) {
            return ResponseEntity.ok().body(commentDto);
        }else {
            System.out.println("댓글 조회 실패");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다.");
        }
    }

    @GetMapping(value = "/comments/{no}") // 댓글 리스트 ]]조회
    public ResponseEntity<?> list(@PathVariable String no) {

        int missNo = Integer.parseInt(no);
        List<CommentDto> commentDtos = commentService.list(missNo);

        if(commentDtos != null) {
            return ResponseEntity.ok().body(commentDtos);
        }else {
            System.out.println("댓글 조회 실패");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다.");
        }
    }

    @DeleteMapping (value = "/comments/{no}") // 댓글 삭제
    public ResponseEntity<?> delete(@PathVariable String no) {

        int commentNo = Integer.parseInt(no);
        int result = commentService.delete(commentNo);

        if(result == SUCCESS) {
            return ResponseEntity.ok().body(result);
        }else {
            System.out.println("댓글 삭제 실패");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 삭제할 수 없습니다.");
        }
    }



}
