package com.ssafy.FFP.Dto;

public class MissnimalDto {

    private int no;
    private String name;
    private String missAddr;
    private String descr;
    private String tel;
    private String color;
    private String kind;
    private String sexCd;
    private String guardian;
    private String distinction;
    private String age;
    private String missDate;
    private String animalCategory;
    private String protectCategory;
    private String img;
    private int author;

    public MissnimalDto() {
    }

    public MissnimalDto(int no, String name, String missAddr, String descr, String tel, String color, String kind, String sexCd, String guardian,
                        String distinction, String age, String missDate, String animalCategory, String protectCategory, String img, int author) {
        this.no = no;
        this.name = name;
        this.missAddr = missAddr;
        this.descr = descr;
        this.tel = tel;
        this.color = color;
        this.kind = kind;
        this.sexCd = sexCd;
        this.guardian = guardian;
        this.distinction = distinction;
        this.age = age;
        this.missDate = missDate;
        this.animalCategory = animalCategory;
        this.protectCategory = protectCategory;
        this.img = img;
        this.author = author;
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

    public String getMissAddr() {
        return missAddr;
    }

    public void setMissAddr(String missAddr) {
        this.missAddr = missAddr;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSexCd() {
        return sexCd;
    }

    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getDistinction() {
        return distinction;
    }

    public void setDistinction(String distinction) {
        this.distinction = distinction;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMissDate() {
        return missDate;
    }

    public void setMissDate(String missDate) {
        this.missDate = missDate;
    }

    public String getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    public String getProtectCategory() {
        return protectCategory;
    }

    public void setProtectCategory(String protectCategory) {
        this.protectCategory = protectCategory;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }
}
