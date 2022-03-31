package com.ssafy.FFP.Dto;

public class JWTDecodeDto {
    private String iss;
    private String sub;
    private String exp;
    private UserDto userInfo;

    public JWTDecodeDto(String iss, String sub, String exp, UserDto userInfo) {
        this.iss = iss;
        this.sub = sub;
        this.exp = exp;
        this.userInfo = userInfo;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public UserDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserDto userInfo) {
        this.userInfo = userInfo;
    }
}
