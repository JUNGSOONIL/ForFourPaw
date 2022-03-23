package com.ssafy.FFP.Controller;

import com.ssafy.FFP.Config.JWT.JwtService;
import com.ssafy.FFP.Config.OAuth.PrincipalOauth2UserService;
import com.ssafy.FFP.Dto.AnalysisResultDto;
import com.ssafy.FFP.Service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })


@RestController
public class AnalysisController {
    @Autowired
    PrincipalOauth2UserService principalOauth2UserService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AnalysisService analysisService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            HttpServletRequest request) throws Exception {

        System.out.println("테스트 메소드 실행");
        AnalysisResultDto result = analysisService.test();
        System.out.println(result.toString());

        return ResponseEntity.ok().body("테스트완료");
    }
}
