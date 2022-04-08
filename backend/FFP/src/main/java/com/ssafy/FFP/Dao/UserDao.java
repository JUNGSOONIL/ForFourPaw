package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public int userRegister(UserDto userDto);
    public int userUpdate(UserDto userDto);
    public UserDto userSelect(int no);
    public UserDto userSelectByEmail(String email);
    public List<MissnimalDto> userSelectOnMiss(int userNo);
    public int userDelete(int no);
    public int duplicateEmail(String email);
    public int duplicateNickname(String nickname);
    public int userRefreshToken(UserDto userDto);
    public String selectRefreshToken(String email);
}
