package com.ssafy.FFP.Dto;

public class UserDto {

    private int no;
    private String name;
    private String nickname;
    private String email;
    private String addrs;
    private String profileImg;
    private String refreshToken;

    public UserDto() {
    }

    public UserDto(int no, String name, String nickname, String email, String addrs, String profileImg, String refreshToken) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.addrs = addrs;
        this.profileImg = profileImg;
        this.refreshToken = refreshToken;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", addrs='" + addrs + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
