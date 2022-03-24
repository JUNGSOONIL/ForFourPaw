package com.ssafy.FFP.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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

import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import com.ssafy.FFP.Service.ShelnimalService;
import com.ssafy.FFP.Sh.ShRunner;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class ShelnimalController {

    @Autowired
    ShelnimalService shelnimalService;

    // 특정 공고 조회
    @GetMapping("/shel/{no}")
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

    // 공고일 종료일이 최소 오늘인 공고 목록 조회
    @GetMapping("/shel")
    public ResponseEntity<?> list(){
        LocalDate seoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow = seoulNow.format(formatter);

        List<ShelnimalDto> shelnimalDtos = shelnimalService.list(formatedNow);

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

        List<ShelnimalDto> shelnimalDtos = shelnimalService.find(searchDto);

        if(shelnimalDtos != null) {
            return ResponseEntity.ok().body(shelnimalDtos);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }
    
    // 비로그인시 유기동물 추천
    @GetMapping("/shel/view/notlogin")
    public ResponseEntity<?> view(){
    	
    	List<ShelnimalDto> shelnimalDto = shelnimalService.view();
    	if(shelnimalDto != null) {
            return ResponseEntity.ok().body(shelnimalDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "오류 발생.");
        }
    }
    
    // 로그인시 유기동물 추천
    @GetMapping("/shel/view/login")
    public ResponseEntity<?> Loview(){
    	ShRunner shRunner = new ShRunner();
    	String[] callCmd = {"C:/Program Files/Git/git-bash.exe","D:/ssafy/Project/Second_Project/S06P22E105/backend/FFP/docker/docker_up.sh", ""};
		Map map = shRunner.execCommand(callCmd);
		return null;
    	
    }
    
//    @Scheduled(cron = "10 * * * * *")
//    public void printDate() {
//    	System.out.println(new Date().toString());
//    }
    
}
