package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "https://i6e203.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class S3Controller {

    private final S3Service s3Service;

    private static final int SUCCESS = 1;

//    @PostMapping(value = "/file/{targetNo}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<List<Integer>> uploadFile(
//            @PathVariable("targetNo") String targetNo,
//            @RequestParam(value = "files", required = false) List<MultipartFile> files) {
//
//        System.out.println("이미지 : " + files.size());
//        List<Integer> result = s3Service.uploadFile(files);
//
//
//        if(result.size() != 0) return new ResponseEntity<List<Integer>>(result, HttpStatus.OK);
//        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "업로드 실패.");
//    }

    @PostMapping(value = "/users/img/{no}") //회원 프로필 변경
    public ResponseEntity<String> uploadFileReturnURL(@PathVariable String no,
    		@RequestParam MultipartFile multipartFile) {
    	System.out.println("회원 프로필 이미지 교체");
    	int userNo = Integer.parseInt(no);
    	String result  = s3Service.uploadFileReturnURL(userNo, multipartFile);

        if(result != null) {
        	System.out.println("프로필 변경 성공");
        	System.out.println(result);
        	return new ResponseEntity<String>(result, HttpStatus.OK);
        }
        else {
        	System.out.println("프로필 변경 실패");
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "업로드 실패.");
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<Integer> deleteFile(@RequestParam String fileName) {
        s3Service.deleteFile(fileName);
        return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
    }
}
