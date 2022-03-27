package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.S3Dto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
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
        int shelNo = Integer.parseInt(no);
        MissnimalDto missnimalDto = missnimalService.select(shelNo);

        if(missnimalDto != null) {
            return ResponseEntity.ok().body(missnimalDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 공고일 종료일이 최소 오늘인 공고 목록 조회
    @GetMapping("/miss")
    public ResponseEntity<?> list(){
        LocalDate seoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow = seoulNow.format(formatter);

        List<MissnimalDto> missnimalDtos = missnimalService.list(formatedNow);

        if(missnimalDtos != null) {
            return ResponseEntity.ok().body(missnimalDtos);
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
    @PostMapping("/miss")
    public ResponseEntity<?> find(@RequestBody SearchDto searchDto){

        List<MissnimalDto> missnimalDtos = missnimalService.find(searchDto);

        if(missnimalDtos != null) {
            return ResponseEntity.ok().body(missnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

//    // 검색
//    @PostMapping("/misses")
//    public ResponseEntity<?> create(
//            @RequestPart(value="userInfo") MissnimalDto missnimalDto,
//            @RequestPart(value="multipartFile", required = false) List<MultipartFile> multipartFile){
//
//        List<Integer> imgNo = new ArrayList<>();
//        if(multipartFile != null){
//            imgNo = s3Service.uploadFile(multipartFile);
//        }
//
//        List<S3Dto> imgs = new ArrayList<>();
//        for (int no : imgNo) {
//            imgs.add(imgService.select(no));
//        }
//
//        int result = missnimalService.create(missnimalDto);
//
//        if(result != 0) {
//            return ResponseEntity.ok().body(result);
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "양식에 맞지 않습니다.");
//        }
//    }
//
//    @PutMapping(value ="/feeds") // 글 수정
//    public ResponseEntity<Integer> update(
//            @RequestPart(value="userInfo") FeedDto feedDto,
//            @RequestPart(value="multipartFile", required = false) List<MultipartFile> multipartFile) {
//
//        List<Integer> imgNo = new ArrayList<>();
//        if(multipartFile != null){
//            imgNo = s3Service.uploadFile(multipartFile);
//        }
//
//        List<ImgDto> imgs = new ArrayList<>();
//        for (int no : imgNo) {
//            imgs.add(imgService.select(no));
//        }
//
//
//        int result = 0;
//        if(imgs.size() != 0) {
//            feedDto.setImgs(imgs);
//            result = feedService.update(feedDto, 0);
//        }
//        else {
//            FeedDto now = feedService.read(feedDto.getNo(), feedDto.getAuthor());
//            feedDto.setImgs(now.getImgs());
//            result = feedService.update(feedDto, 1);
//        }
//
//
//        if(result == SUCCESS) {
//            return new ResponseEntity<Integer>(result, HttpStatus.OK);
//        }else {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정에 실패 했습니다.");
//        }
//    }
}
