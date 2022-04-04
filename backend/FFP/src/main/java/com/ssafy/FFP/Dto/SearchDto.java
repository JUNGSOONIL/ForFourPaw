package com.ssafy.FFP.Dto;

public class SearchDto {

    private String kindCd;
    private String colorCd;
    private String age;
    private String sexCd;
    private String neuterYn;
    private String happenDt;
    private String happenPlace;
    private String careAddr;
    private String processState;
    private int limit;
    private String offset;
//    private int offset;

    public SearchDto(String kindCd, String colorCd, String age, String sexCd, String neuterYn, String happenDt,
                     String happenPlace, String careAddr, String processState, int limit, String offset) {
        this.kindCd = kindCd;
        this.colorCd = colorCd;
        this.age = age;
        this.sexCd = sexCd;
        this.neuterYn = neuterYn;
        this.happenDt = happenDt;
        this.happenPlace = happenPlace;
        this.careAddr = careAddr;
        this.processState = processState;
        this.limit = limit;
        this.offset = offset;
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
    
    public String getCareAddr() {
		return careAddr;
	}

	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
//
//    public int getOffset() {
//        return offset;
//    }
//
//    public void setOffset(int offset) {
//        this.offset = offset;
//    }


    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    @Override
    public String toString() {
        return "SearchDto{" +
                "kindCd='" + kindCd + '\'' +
                ", colorCd='" + colorCd + '\'' +
                ", age='" + age + '\'' +
                ", sexCd='" + sexCd + '\'' +
                ", neuterYn='" + neuterYn + '\'' +
                ", happenDt='" + happenDt + '\'' +
                ", happenPlace='" + happenPlace + '\'' +
                ", careAddr='" + careAddr + '\'' +
                ", processState='" + processState + '\'' +
                ", limit=" + limit +
                ", offset='" + offset + '\'' +
                '}';
    }
}