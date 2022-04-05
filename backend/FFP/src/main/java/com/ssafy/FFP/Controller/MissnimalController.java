package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Dto.*;
import com.ssafy.FFP.Service.MissnimalService;
import com.ssafy.FFP.Service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class MissnimalController {

    @Autowired
    MissnimalService missnimalService;

    @Autowired
    S3Service s3Service;

    // 특정 공고 조회
    @GetMapping("/miss/{no}")
    public ResponseEntity<?> select(@PathVariable String no){
        int missNo = Integer.parseInt(no);
        MissnimalDto missnimalDto = missnimalService.select(missNo);
        System.out.println("missDto : " + missnimalDto);
        if(missnimalDto != null) {
            return ResponseEntity.ok().body(missnimalDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 공고일 종료일이 최소 오늘인 공고 목록 조회
    @GetMapping("/misses/{offset}")
    public ResponseEntity<?> list(@PathVariable String offset){
        int os = Integer.parseInt(offset);
        os = (os - 1) * 9;
        List<MissnimalDto> missnimalDtos = missnimalService.list(os, 9);
        List<MissnimalDto> count = missnimalService.list(0, 100000);
        CountingDto countingDto = new CountingDto(count.size(), null, missnimalDtos);

        if(missnimalDtos != null) {
            return ResponseEntity.ok().body(countingDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 실종 동물 찾아주기
    @GetMapping("/miss/match/{no}")
    public ResponseEntity<?> match(@PathVariable String no){
        int userNo = Integer.parseInt(no);
        List<MissnimalDto> missnimalDtos = missnimalService.match(userNo);

        if(missnimalDtos != null) {
            return ResponseEntity.ok().body(missnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 검색
    @PostMapping("/miss/search")
    public ResponseEntity<?> find(@RequestBody SearchDto searchDto){

        searchDto.setLimit(9);
        int os = searchDto.getOffset();
        os = (os - 1) * 9;
        searchDto.setOffset(os);
        List<MissnimalDto> missnimalDtos = missnimalService.find(searchDto);
        searchDto.setLimit(100000);
        searchDto.setOffset(0);
        List<MissnimalDto> count = missnimalService.find(searchDto);

        CountingDto countingDto = new CountingDto(count.size(), null, missnimalDtos);

        if(missnimalDtos != null) {
            return ResponseEntity.ok().body(countingDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 글 작성
    @PostMapping("/authorization/miss")
    public ResponseEntity<?> create(
            @RequestPart(value="missData") MissnimalDto missnimalDto,
            @RequestPart(value="multipartFile", required = false) List<MultipartFile> multipartFile){

        System.out.println(missnimalDto.toString());
        List<Integer> imgNo = new ArrayList<>();
        if(multipartFile != null){
            imgNo = s3Service.uploadFile(multipartFile);
        }

        List<S3Dto> imgs = new ArrayList<>();
        for (int no : imgNo) {
            System.out.println("no: " + no);
            imgs.add(s3Service.select(no));
        }

        int result = missnimalService.create(missnimalDto, imgs.get(0));

        if(result != 0) {
            return ResponseEntity.ok().body(result);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "양식에 맞지 않습니다.");
        }
    }

    // 글 수정
    @PutMapping("/authorization/miss")
    public ResponseEntity<?> update(
            @RequestPart(value="missData") MissnimalDto missnimalDto,
            @RequestPart(value="multipartFile", required = false) List<MultipartFile> multipartFile){

        System.out.println(missnimalDto.toString());
        int result = 0;
        if(multipartFile != null) {
            List<Integer> imgNo = new ArrayList<>();
            if (multipartFile != null) {
                imgNo = s3Service.uploadFile(multipartFile);
            }

            List<S3Dto> imgs = new ArrayList<>();
            for (int no : imgNo) {
                System.out.println("no: " + no);
                imgs.add(s3Service.select(no));
            }

            result = missnimalService.update(missnimalDto, imgs.get(0));
        }
        else {
            result = missnimalService.update(missnimalDto, null);
        }

        if(result != 0) {
            return ResponseEntity.ok().body(result);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "양식에 맞지 않습니다.");
        }
    }
    
    @DeleteMapping("/authorization/miss/{no}")
    public ResponseEntity<?> delete(@PathVariable String no){
        int missNo = Integer.parseInt(no);

        if (missnimalService.delete(missNo) != 0) {
            return ResponseEntity.ok().body(1);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제에 실패했습니다.");
        }
                
    }
}
