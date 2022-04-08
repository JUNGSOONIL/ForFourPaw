package com.ssafy.FFP.Config.JWT;

import com.ssafy.FFP.Dao.UserDao;
import com.ssafy.FFP.Dto.TokenDto;
import com.ssafy.FFP.Dto.UserDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    @Autowired
    UserDao userDao;


    @Value("${jwt.secret}")
    private String encodeKey;
    private final Integer accessExpMin = 30;
    private final Integer refreshExpMin = 10080;

    public String createAccess(String email) {
        UserDto userDto = userDao.userSelectByEmail(email);


        System.out.println("==== create Access === " + "\n" + userDto.toString());
        return createJws(accessExpMin, userDto);
    }

    public String createRefresh() {
        return createJws(refreshExpMin, null);
    }

    public TokenDto create(UserDto userInfo) {

        // Create Access Token
        String accessJws = createJws(accessExpMin, userInfo);

        // Create Refresh Token
        String refreshJws = createJws(refreshExpMin, null);

        TokenDto tokens = new TokenDto();
        tokens.setAccessJws(accessJws);
        tokens.setRefreshJws(refreshJws);

        return tokens;

    }

    public String createJws(Integer expMin, UserDto userInfo) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(encodeKey));

        //JWT Builder create
        JwtBuilder builder = Jwts.builder();

        // header configuration
        builder.setHeaderParam("typ", "JWT");

        // claim configuration
        builder.setIssuer("ForFourPaw");
        builder.setSubject("FFP");
        builder.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expMin));
        builder.setIssuedAt(new Date());


        if(userInfo != null) {
            builder.claim("userInfo", userInfo);
        }

        // signature configuration
        builder.signWith(secretKey);
        String jws = builder.compact();

        return jws;

    }

    public boolean validate(String token) {
        Jws<Claims> jws;
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(encodeKey));
        System.out.println("=================================================================");
        System.out.println("validate: " + secretKey);
        try {
            JwtParserBuilder jpb = Jwts.parserBuilder();
            jpb.setSigningKey(secretKey);
            jws = jpb.build().parseClaimsJws(token);

            System.out.println("jws : " + jws);
            System.out.println("jws.gs : " + jws.getBody().getSubject());

            return true;
        }catch(JwtException e) {
            return false;
        }

    }

    public String decode(String token) {

        System.out.println("decode token : " + token);
        String[] splitToken = token.split("\\.");
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] decodedBytes = decoder.decode(splitToken[1]);
        byte[] decodedBytes = Base64Utils.decodeFromUrlSafeString(splitToken[1]);

        String decodedString = null;

        try {
            decodedString = new String(decodedBytes, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedString;

    }
}
