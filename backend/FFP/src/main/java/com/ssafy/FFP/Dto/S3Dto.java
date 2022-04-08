package com.ssafy.FFP.Dto;

public class S3Dto {

    private int no;
    private int targetNo;
    private String imgName;
    private String imgLink;

    public S3Dto() {
    }

    public S3Dto(int no, int targetNo, String imgName, String imgLink) {
        this.no = no;
        this.targetNo = targetNo;
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

    public int getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(int targetNo) {
        this.targetNo = targetNo;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public String toString() {
        return "S3Dto{" +
                "no=" + no +
                ", targetNo=" + targetNo +
                ", imgName='" + imgName + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }
}
