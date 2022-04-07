package com.ssafy.FFP.Config;

import com.ssafy.FFP.Config.JWT.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    JwtInterceptor jwtInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")  
                .exposedHeaders("at-jwt-token", "at-jwt-access-token", "at-jwt-refresh-token")
                .maxAge(3000);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("####### Register Interceptor: JwtInterceptor!!!");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/users/update/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/login/oauth/**")
                .excludePathPatterns("/kauth.kakao.com/**")
                .excludePathPatterns("/kapi.kakao.com/**")
                .excludePathPatterns("/error/**")
                .excludePathPatterns("/shel/view/notlogin")
                .excludePathPatterns("/shel/detail/notlogin/**")
                .excludePathPatterns("/dataset/**")
                .excludePathPatterns("/shel/**")
                .excludePathPatterns("/shel")
                .excludePathPatterns("/miss")
                .excludePathPatterns("/misses/**")
                .excludePathPatterns("/loaddata")
                .excludePathPatterns("/miss/**");

    }
  
}
