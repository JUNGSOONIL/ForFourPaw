package com.ssafy.FFP.Service;


import com.ssafy.FFP.Dao.S3Dao;
import com.ssafy.FFP.Dao.UserDao;
import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.S3Dto;
import com.ssafy.FFP.Dto.UserDto;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    S3Service s3Service;

    @Autowired
    S3Dao s3Dao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public int userRegister(UserDto userDto) { // 회원 가입
        if (userDao.userRegister(userDto) == SUCCESS) // 성공
            return SUCCESS;
        else // 실패
            return FAIL;
    }

    @Override
    public UserDto userSelect(int no) { // 회원 검색

        UserDto userDto = userDao.userSelect(no);
        return userDto;
    }

    @Override
    public UserDto userSelectByEmail(String email) {
        UserDto userDto = userDao.userSelectByEmail(email);
        return userDto;
    }

    @Override
    public List<MissnimalDto> userSelectOnMiss(int userNo) {
        List<MissnimalDto> missnimalDtos = userDao.userSelectOnMiss(userNo);
        return missnimalDtos;
    }

    @Override
    public int duplicateEmail(String email) { // 이메일 중복 체크
        if (userDao.duplicateEmail(email) == 0) // 사용가능
            return SUCCESS;
        else // 중복
            return FAIL;
    }

    @Override
    public int duplicateNickname(String nickname) { // 닉네임 중복 체크
        if (userDao.duplicateNickname(nickname) == 0) // 사용가능
            return SUCCESS;
        else // 중복
            return FAIL;
    }

    @Override
    public int userDelete(int no) { // 회원 삭제
        if (userDao.userDelete(no) == SUCCESS)
            return SUCCESS;
        else // 실패
            return FAIL;
    }

    public int userUpdate(UserDto userDto, S3Dto img) { // 회원 수정
        UserDto raw = userDao.userSelect(userDto.getNo());
        if(img != null) {
            S3Dto latest = s3Dao.selectByLink(raw.getProfileImg());
            System.out.println("latest : " + latest.toString());
            if(latest.getNo() != 10) s3Service.deleteFile(latest.getImgName());
            userDto.setProfileImg(img.getImgLink());
        } else {
            System.out.println(raw.toString());
            userDto.setProfileImg(raw.getProfileImg());
        }
        int result = userDao.userUpdate(userDto);
        return result;
    }

    @Override
    public int userRefreshToken(UserDto userDto) {
        return userDao.userRefreshToken(userDto);
    }

    @Override
    public String selectRefreshToken(String email) {
        return userDao.selectRefreshToken(email);
    }
}
