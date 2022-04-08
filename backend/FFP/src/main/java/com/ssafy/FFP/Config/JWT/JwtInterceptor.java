package com.ssafy.FFP.Config.JWT;

import com.google.gson.Gson;
import com.ssafy.FFP.Dto.JWTDecodeDto;
import com.ssafy.FFP.Dto.UserDto;
import com.ssafy.FFP.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    JwtService jwtService;

    @Autowired
     UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("####### Interceptor preHandle Start!!!");

        String atJwtToken = request.getHeader("at-jwt-access-token");
        String atJwtRefreshToken = request.getHeader("at-jwt-refresh-token");
 
        System.out.println("at-jwt-access-token : " + atJwtToken);
        System.out.println("at-jwt-refresh-token : " + atJwtRefreshToken);
        System.out.println("request method : " + request.getMethod());
        System.out.println("request URI : " + request.getRequestURI());


        //OPTION은 통과
        if ("OPTIONS".equals(request.getMethod())) {
            System.out.println("request method is OPTIONS!!");
            return true;
        }

        if(atJwtRefreshToken == null) {
            if(atJwtToken != null && atJwtToken.length() > 0) {
                if(jwtService.validate(atJwtToken)) return true;
                else throw new IllegalArgumentException("Access Token Error!!!");
            }else {
                throw new IllegalArgumentException("No Access Token!!!");
            }
        }else {
            System.out.println("check : pass" );
            if(jwtService.validate(atJwtRefreshToken)) {
                String accessTokenDecode = jwtService.decode(atJwtToken);
                System.out.println("accessDto : " + accessTokenDecode);
                Gson gson = new Gson();
                JWTDecodeDto jwtPayload = gson.fromJson(accessTokenDecode, JWTDecodeDto.class);

                System.out.println(jwtPayload.getUserInfo().getEmail());
                String refreshTokenInDBMS = userService.selectRefreshToken(jwtPayload.getUserInfo().getEmail());
                System.out.println(refreshTokenInDBMS);

                if(refreshTokenInDBMS.equals(atJwtRefreshToken)) {
                    System.out.println("일치합니다!!!");
                   // String accessJws = jwtService.createJws(30, jwtPayload.getUserInfo());
                    String accessJws = jwtService.createAccess(jwtPayload.getUserInfo().getEmail());
                    response.addHeader("at-jwt-access-token", accessJws);

                }else {
                    throw new IllegalArgumentException("Refresh Token Error!!! ND");
                }
                return true;
            }else {
                throw new IllegalArgumentException("Refresh Token Error!!! NN");
            }
        }
    }

}