package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.S3Dto;
import com.ssafy.FFP.Dto.UserDto;

import java.util.List;

public interface UserService {
    public int userRegister(UserDto dto);
    public UserDto userSelect(int no);
    public UserDto userSelectByEmail(String email);
    public List<MissnimalDto> userSelectOnMiss(int userNo);
    public int userDelete(int no);
    public int duplicateEmail(String email);
    public int duplicateNickname(String nickname);
    public int userUpdate(UserDto changuserDto, S3Dto s3Dto);
    public int userRefreshToken(UserDto userDto);
    public String selectRefreshToken(String email);
}
