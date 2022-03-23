package com.ssafy.FFP.Dto;

public class ShelnimalDto {

    private int no;
    private String category;
    private String kind;
    private String color;
    private String age;
    private String careAddr;
    private String shelter;
    private String shelterTel;
    private String neuterYn;
    private String happenPlace;
    private String precessState;
    private String sumImg;
    private String img;
    private String noticeSdt;
    private String noticeEdt;
    private String descr;
    private String weight;
    private String sexCd;

    public ShelnimalDto(int no, String category, String kind, String color, String age, String careAddr, String shelter, String shelterTel,
                        String neuterYn, String happenPlace, String precessState, String sumImg, String img,
                        String noticeSdt, String noticeEdt, String descr, String weight, String sexCd) {
        this.no = no;
        this.category = category;
        this.kind = kind;
        this.color = color;
        this.age = age;
        this.careAddr = careAddr;
        this.shelter = shelter;
        this.shelterTel = shelterTel;
        this.neuterYn = neuterYn;
        this.happenPlace = happenPlace;
        this.precessState = precessState;
        this.sumImg = sumImg;
        this.img = img;
        this.noticeSdt = noticeSdt;
        this.noticeEdt = noticeEdt;
        this.descr = descr;
        this.weight = weight;
        this.sexCd = sexCd;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCareAddr() {
        return careAddr;
    }

    public void setCareAddr(String careAddr) {
        this.careAddr = careAddr;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    public String getShelterTel() {
        return shelterTel;
    }

    public void setShelterTel(String shelterTel) {
        this.shelterTel = shelterTel;
    }

    public String getNeuterYn() {
        return neuterYn;
    }

    public void setNeuterYn(String neuterYn) {
        this.neuterYn = neuterYn;
    }

    public String getHappenPlace() {
        return happenPlace;
    }

    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace;
    }

    public String getPrecessState() {
        return precessState;
    }

    public void setPrecessState(String precessState) {
        this.precessState = precessState;
    }

    public String getSumImg() {
        return sumImg;
    }

    public void setSumImg(String sumImg) {
        this.sumImg = sumImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNoticeSdt() {
        return noticeSdt;
    }

    public void setNoticeSdt(String noticeSdt) {
        this.noticeSdt = noticeSdt;
    }

    public String getNoticeEdt() {
        return noticeEdt;
    }

    public void setNoticeEdt(String noticeEdt) {
        this.noticeEdt = noticeEdt;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSexCd() {
        return sexCd;
    }

    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }
}
