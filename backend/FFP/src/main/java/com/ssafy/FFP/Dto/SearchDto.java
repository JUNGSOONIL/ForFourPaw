package com.ssafy.FFP.Dto;

public class SearchDto {

    private String kindCd;
    private String colorCd;
    private String age;
    private String sexCd;
    private String neuterYn;
    private String happenDt;
    private String happenPlace;

    public SearchDto(String kindCd, String colorCd, String age, String sexCd, String neuterYn, String happenDt, String happenPlace) {
        this.kindCd = kindCd;
        this.colorCd = colorCd;
        this.age = age;
        this.sexCd = sexCd;
        this.neuterYn = neuterYn;
        this.happenDt = happenDt;
        this.happenPlace = happenPlace;
    }

    public SearchDto() {

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
}