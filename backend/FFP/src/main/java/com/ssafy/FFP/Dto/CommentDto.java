package com.ssafy.FFP.Dto;

import java.time.LocalDateTime;

public class CommentDto {

    private int no;
    private int author;
    private LocalDateTime writeTime;
    private String descr;


    public CommentDto() {
    }

    public CommentDto(int no, int author, LocalDateTime writeTime, String descr) {
        this.no = no;
        this.author = author;
        this.writeTime = writeTime;
        this.descr = descr;
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
}
