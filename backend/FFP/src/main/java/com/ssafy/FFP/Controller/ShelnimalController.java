package com.ssafy.FFP.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import com.ssafy.FFP.Service.ShelnimalService;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class ShelnimalController {

    @Autowired
    ShelnimalService shelnimalService;

    // 특정 공고 조회
    @GetMapping("/shel/detail/{no}")
    public ResponseEntity<?> select(@PathVariable String no){
        int shelNo = Integer.parseInt(no);
        ShelnimalDto shelnimalDto = shelnimalService.select(shelNo);

        if(shelnimalDto != null) {
            return ResponseEntity.ok().body(shelnimalDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 특정 공고 조회
    @GetMapping("/shel/detail/notlogin/{no}")
    public ResponseEntity<?> selectByNotLogin(@PathVariable String no){
        int shelNo = Integer.parseInt(no);
        ShelnimalDto shelnimalDto = shelnimalService.select(shelNo);

        if(shelnimalDto != null) {
            return ResponseEntity.ok().body(shelnimalDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 공고일 종료일이 최소 오늘인 공고 목록 조회
    @GetMapping("/shel/{offset}")
    public ResponseEntity<?> list(@PathVariable String offset){
        LocalDate seoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formatedNow = seoulNow.format(formatter);
        int sdt = Integer.parseInt(formatedNow);
        int os = Integer.parseInt(offset);
        List<ShelnimalDto> shelnimalDtos = shelnimalService.list(sdt, os);

        if(shelnimalDtos != null) {
            return ResponseEntity.ok().body(shelnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 유기 동물 제안
    @GetMapping("/shel/match/{no}")
    public ResponseEntity<?> match(@PathVariable String no){
        int userNo = Integer.parseInt(no);
        List<ShelnimalDto> shelnimalDtos = shelnimalService.match(userNo);

        if(shelnimalDtos != null) {
            return ResponseEntity.ok().body(shelnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }

    // 검색
    @PostMapping("/shel")
    public ResponseEntity<?> find(@RequestBody SearchDto searchDto){

        List<DatasetDto> shelnimalDtos = shelnimalService.find(searchDto);

        if(shelnimalDtos != null) {
            return ResponseEntity.ok().body(shelnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }
    
    // 비로그인시 메인페이지 유기동물 추천
    @GetMapping("/shel/view/notlogin")
    public ResponseEntity<?> mainList(){
    	System.out.println("mainList : 비로그인");
        List<DatasetDto> shelnimalDtos = shelnimalService.mainList();

        if(shelnimalDtos != null) {
            return ResponseEntity.ok().body(shelnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }
    
    // 로그인시 메인페이지 유기동물 추천
    @GetMapping("/shel/view/login/{no}")
    public ResponseEntity<?> mainListLogin(@PathVariable String no){
    	System.out.println("mainList : 로그인 " + no);
        List<DatasetDto> shelnimalDtos = shelnimalService.mainList();

        if(shelnimalDtos != null) {
            return ResponseEntity.ok().body(shelnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }
    
    // 품종 검색
    @GetMapping("/shel/search/list/{kind}")
    public ResponseEntity<?> searchList(@PathVariable String kind){
    	System.out.println("searchList " + kind);
        List<String> kinds = shelnimalService.searchList(kind);

        if(kinds != null) {
            return ResponseEntity.ok().body(kinds);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }
}
