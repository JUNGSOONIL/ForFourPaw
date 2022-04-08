package com.ssafy.FFP.Dto;

import java.time.LocalDateTime;

public class CommentDto {

    private int no;
    private int author;
    private LocalDateTime writeTime;
    private String descr;
    private int missNo;
    private String authorNickName;
    private String profileImage;

    public CommentDto() {
    }

    public CommentDto(int no, int author, LocalDateTime writeTime, String descr, int missNo, String authorNickName, String profileImage) {
        this.no = no;
        this.author = author;
        this.writeTime = writeTime;
        this.descr = descr;
        this.missNo = missNo;
        this.authorNickName = authorNickName;
        this.profileImage = profileImage;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public LocalDateTime getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(LocalDateTime writeTime) {
        this.writeTime = writeTime;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getMissNo() {
        return missNo;
    }

    public void setMissNo(int missNo) {
        this.missNo = missNo;
    }

    public String getAuthorNickName() {
        return authorNickName;
    }

    public void setAuthorNickName(String authorNickName) {
        this.authorNickName = authorNickName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
