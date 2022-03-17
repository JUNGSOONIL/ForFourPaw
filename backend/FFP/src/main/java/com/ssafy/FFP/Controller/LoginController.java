package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Config.JWT.JwtService;
import com.ssafy.FFP.Config.OAuth.PrincipalOauth2UserService;
import com.ssafy.FFP.Dto.TokenDto;
import com.ssafy.FFP.Dto.UserDto;
import com.ssafy.FFP.Service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })
@RestController
public class LoginController {

    @Autowired
    PrincipalOauth2UserService principalOauth2UserService;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login/oauth/google", method = RequestMethod.POST)
    public ResponseEntity<?> tokenVerify(String idToken){
        System.out.println("RequestBody value : " + idToken);
        UserDto user =  principalOauth2UserService.tokenVerify(idToken);
        HttpHeaders res = new HttpHeaders();

        if (user.getEmail() != null) {
            principalOauth2UserService.insertUser(user);
            user = userService.userSelectByEmail(user.getEmail());

            TokenDto atJWT = jwtService.create(user);
            System.out.println("로그인 컨트롤 atJWT");
            System.out.println(atJWT);
            res.add("at-jwt-access-token", atJWT.getAccessJws());
            res.add("at-jwt-refresh-token", atJWT.getRefreshJws());
            user.setRefreshToken(atJWT.getRefreshJws());
            userService.userRefreshToken(user);
        }

        return ResponseEntity.ok().headers(res).body(user);
    }


    /////////////////////////카카오

    @GetMapping(value = "/login/getKakaoAuthUrl")
    public ResponseEntity<?> getKakaoAuthUrl(
            HttpServletRequest request) throws Exception {
        String reqUrl =
                "https://kauth.kakao.com/oauth/authorize"
                        + "?client_id=54115c9fc805ecfb96348d18733e6e4a"
                        + "&redirect_uri=https://j6e105.p.ssafy.io/login/oauth/kakao"
                        + "&response_type=code";

        return ResponseEntity.ok().body(reqUrl);
    }

    // 카카오 연동정보 조회
    @RequestMapping(value = "/login/oauth/kakao", method = RequestMethod.POST)
    public ResponseEntity<?> oauthKakao(
            @RequestBody String code) throws Exception {

        System.out.println("#########" + code);
        String access_Token = principalOauth2UserService.getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);


        HashMap<String, Object> userInfo = principalOauth2UserService.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));

        JSONObject kakaoInfo =  new JSONObject(userInfo);
        UserDto userDto = new UserDto();
        userDto.setEmail((String) userInfo.get("email"));
        userDto.setNickname((String) userInfo.get("nickname"));
        userDto.setProfileImg((String) userInfo.get("profile_image_url"));

        principalOauth2UserService.insertUser(userDto);
        UserDto user = userService.userSelectByEmail(userDto.getEmail());

        HttpHeaders res = new HttpHeaders();
        TokenDto atJWT = jwtService.create(user);
        System.out.println("로그인 컨트롤 atJWT");
        System.out.println(atJWT);
        res.add("at-jwt-access-token", atJWT.getAccessJws());
        res.add("at-jwt-refresh-token", atJWT.getRefreshJws());
        user.setRefreshToken(atJWT.getRefreshJws());
        userService.userRefreshToken(user);

        return ResponseEntity.ok().headers(res).body(kakaoInfo);
    }
}
