package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Config.JWT.JwtService;
import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.S3Dto;
import com.ssafy.FFP.Dto.UserDto;
import com.ssafy.FFP.Service.S3Service;
import com.ssafy.FFP.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    S3Service s3Service;

    private static final int SUCCESS = 1;

    @PostMapping(value = "/register") // 회원가입
    public ResponseEntity<Integer> register(@RequestBody UserDto userDto) {

        if (userService.userRegister(userDto) == SUCCESS) {
            System.out.println("회원 가입 성공");
            System.out.println(userDto);
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            System.out.println("회원 가입 실패");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "가입 양식이 올바르지 않습니다.");
        }
    }

    @GetMapping(value = "/users/{no}") // 회원번호로 회원 정보 반환
    public ResponseEntity<UserDto> select(@PathVariable String no) {
        int userNo = Integer.parseInt(no);
        UserDto userDto = userService.userSelect(userNo);
        if (userDto.getEmail() != null) {
            System.out.println("회원 번호 검색 성공");
            System.out.println(userDto);
            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } else {
            System.out.println("회원 번호 검색 실패");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하는 유저가 없습니다.");
        }
    }

    @GetMapping(value = "/users/miss/{no}") // 회원번호로 회원 작성글 반환
    public ResponseEntity<?> selectOnMiss(@PathVariable String no) {
        int userNo = Integer.parseInt(no);
        List<MissnimalDto> missnimalDtos = userService.userSelectOnMiss(userNo);
        if (missnimalDtos != null) {
            return ResponseEntity.ok().body(missnimalDtos);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하는 글이 없습니다.");
        }
    }

    @GetMapping(value = "/users/checkByEmail/{email}") // 이메일 중복검사
    public ResponseEntity<Integer> duplicateEmail(@PathVariable String email) {
        if (userService.duplicateEmail(email) == SUCCESS) {
            System.out.println("이메일 중복 검사 미사용 " + email);
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            System.out.println("이메일 중복 검사 사용중 " + email);
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 사용중인 이메일 입니다.");
        }
    }

    @GetMapping(value = "/users/checkByNickname/{nickname}") // 닉네임 중복검사
    public ResponseEntity<Integer> duplicateNickname(@PathVariable String nickname) {
        if (userService.duplicateNickname(nickname) == SUCCESS) {
            System.out.println("닉네임 중복 검사 미사용 " + nickname);
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            System.out.println("닉네임 중복 검사 사용중 " + nickname);
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 사용중인 닉네임 입니다.");
        }
    }

    @PutMapping(value ="/users") //회원 수정
    public ResponseEntity<?> update(
            @RequestPart(value="userInfo") UserDto user,
            @RequestPart(value="multipartFile", required = false) List<MultipartFile> multipartFile) {
        HttpHeaders res = new HttpHeaders();
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

            result = userService.userUpdate(user, imgs.get(0));
        }else {
            result = userService.userUpdate(user, null);
        }

        if(result != 0) { // 기존정보와 입력받은 정보를 비교해서 새로 갱신
            UserDto userDto = userService.userSelect(user.getNo());
            String accessToken = jwtService.createAccess(userDto.getEmail());
            System.out.println("==============업데이트 엑세스 토큰 ==========" + "\n" + accessToken);
            res.clear();
            res.add("at-jwt-access-token2", accessToken);
            return ResponseEntity.ok().headers(res).body(userDto);
        }else {
            System.out.println("회원 수정 실패");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정할 내용을 확인해 주세요.");
        }
    }

    @DeleteMapping(value = "/users/{no}") //회원 탈퇴 회원 번호로 회원 정보 삭제
    public ResponseEntity<Integer> delete(@PathVariable String no) {
        int userNo = Integer.parseInt(no);
        if (userService.userDelete(userNo) == SUCCESS) {
            System.out.println("회원 탈퇴 성공");
            System.out.println("회원 번호" + no);
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            System.out.println("회원 탈퇴 실패");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하는 유저가 없습니다.");
        }
    }
}
