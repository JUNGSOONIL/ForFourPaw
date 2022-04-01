package com.ssafy.FFP.Dto;

public class MissnimalDto {

    private int no;
    private String name;
    private String kindCd;
    private String colorCd;
    private String age;
    private String sexCd;
    private String neuterYn;
    private int author;
    private String careTel;
    private String happenDt;
    private String happenPlace;
    private String descr;
    private String profile;
    private String authorName;
    private String writeTime;

    public MissnimalDto() {
    }

    public MissnimalDto(int no, String name, String kindCd, String colorCd, String age, String sexCd, String neuterYn,
                        int author, String careTel, String happenDt, String happenPlace, String descr, String profile,
                        String authorName, String writeTime) {
        this.no = no;
        this.name = name;
        this.kindCd = kindCd;
        this.colorCd = colorCd;
        this.age = age;
        this.sexCd = sexCd;
        this.neuterYn = neuterYn;
        this.author = author;
        this.careTel = careTel;
        this.happenDt = happenDt;
        this.happenPlace = happenPlace;
        this.descr = descr;
        this.profile = profile;
        this.authorName = authorName;
        this.writeTime = writeTime;
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

    public String getKindCd() {
        return kindCd;
    }

    public void setKindCd(String kindCd) {
        this.kindCd = kindCd;
    }

    public String getColorCd() {
        return colorCd;
    }

    public void setColorCd(String colorCd) {
        this.colorCd = colorCd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSexCd() {
        return sexCd;
    }

    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    public String getNeuterYn() {
        return neuterYn;
    }

    public void setNeuterYn(String neuterYn) {
        this.neuterYn = neuterYn;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getCareTel() {
        return careTel;
    }

    public void setCareTel(String careTel) {
        this.careTel = careTel;
    }

    public String getHappenDt() {
        return happenDt;
    }

    public void setHappenDt(String happenDt) {
        this.happenDt = happenDt;
    }

    public String getHappenPlace() {
        return happenPlace;
    }

    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    @Override
    public String toString() {
        return "MissnimalDto{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", kindCd='" + kindCd + '\'' +
                ", colorCd='" + colorCd + '\'' +
                ", age='" + age + '\'' +
                ", sexCd='" + sexCd + '\'' +
                ", neuterYn='" + neuterYn + '\'' +
                ", author=" + author +
                ", careTel='" + careTel + '\'' +
                ", happenDt='" + happenDt + '\'' +
                ", happenPlace='" + happenPlace + '\'' +
                ", descr='" + descr + '\'' +
                ", profile='" + profile + '\'' +
                ", authorName='" + authorName + '\'' +
                ", writeTime='" + writeTime + '\'' +
                '}';
    }
}
