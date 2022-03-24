package com.ssafy.FFP.Dto;

public class S3Dto {

    private int no;
    private String imgName;
    private String imgLink;

    public S3Dto() {
    }

    public S3Dto(int no, String imgName, String imgLink) {
        this.no = no;
        this.imgName = imgName;
        this.imgLink = imgLink;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
