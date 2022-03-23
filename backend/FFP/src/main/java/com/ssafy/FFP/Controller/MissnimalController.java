package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import com.ssafy.FFP.Service.MissnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class MissnimalController {

    @Autowired
    MissnimalService missnimalService;

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
}
