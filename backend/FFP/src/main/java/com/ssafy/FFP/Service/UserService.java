package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dto.UserDto;

public interface UserService {
    public int userRegister(UserDto dto);
    public UserDto userSelect(int no);
    public UserDto userSelectByEmail(String email);
    public int userDelete(int no);
    public int duplicateEmail(String email);
    public int duplicateNickname(String nickname);
    public int userUpdate(UserDto changuserDto);
    public int userRefreshToken(UserDto userDto);
    public String selectRefreshToken(String email);
}
