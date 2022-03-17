package com.ssafy.FFP.Service;


import com.ssafy.FFP.Dao.UserDao;
import com.ssafy.FFP.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

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

    public int userUpdate(UserDto userDto, UserDto changeuserDto) { // 회원 수정
        if (userDao.userUpdate(userDto) == SUCCESS) // 변경된 기존 유저정보를 가지고 db내용을 변경함
            return SUCCESS;
        else // 실패
            return FAIL;
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
