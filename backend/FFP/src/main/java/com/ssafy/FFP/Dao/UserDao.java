package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public int userRegister(UserDto userDto);
    public int userUpdate(UserDto userDto);
    public UserDto userSelect(int no);
    public UserDto userSelectByEmail(String email);
    public int userDelete(int no);
    public int duplicateEmail(String email);
    public int duplicateNickname(String nickname);
    public int userRefreshToken(UserDto userDto);
    public String selectRefreshToken(String email);
}
