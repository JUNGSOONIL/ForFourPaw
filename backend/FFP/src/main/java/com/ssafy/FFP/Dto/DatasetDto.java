package com.ssafy.FFP.Dto;

public class DatasetDto {
	private int no;
    private String desertionNo;
    private String filename;
    private String happenDt;
    private String happenPlace;
    private String kindCd;
    private String colorCd;
    private String age;
    private String weight;
    private String noticeNo;
    private String noticeSdt;
    private String noticeEdt;
    private String popfile;
    private String processState;
    private String sexCd;
    private String neuterYn;
    private String specialMark;
    private String careNm;
    private String careTel;
    private String careAddr;
    private String orgNm;
    private String chargeNm;
    private String officetel;

    
	@Override
	public String toString() {
		return "DatasetDto [no=" + no + ", desertionNo=" + desertionNo + ", filename=" + filename + ", happenDt="
				+ happenDt + ", happenPlace=" + happenPlace + ", kindCd=" + kindCd + ", colorCd=" + colorCd + ", age="
				+ age + ", weight=" + weight + ", noticeNo=" + noticeNo + ", noticeSdt=" + noticeSdt + ", noticeEdt="
				+ noticeEdt + ", popfile=" + popfile + ", processState=" + processState + ", sexCd=" + sexCd
				+ ", neuterYn=" + neuterYn + ", specialMark=" + specialMark + ", careNm=" + careNm + ", careTel="
				+ careTel + ", careAddr=" + careAddr + ", orgNm=" + orgNm + ", chargeNm=" + chargeNm + ", officetel="
				+ officetel + "]";
	}


	public DatasetDto(int no, String desertionNo, String filename, String happenDt, String happenPlace, String kindCd,
			String colorCd, String age, String weight, String noticeNo, String noticeSdt, String noticeEdt,
			String popfile, String processState, String sexCd, String neuterYn, String specialMark, String careNm,
			String careTel, String careAddr, String orgNm, String chargeNm, String officetel) {
		super();
		this.no = no;
		this.desertionNo = desertionNo;
		this.filename = filename;
		this.happenDt = happenDt;
		this.happenPlace = happenPlace;
		this.kindCd = kindCd;
		this.colorCd = colorCd;
		this.age = age;
		this.weight = weight;
		this.noticeNo = noticeNo;
		this.noticeSdt = noticeSdt;
		this.noticeEdt = noticeEdt;
		this.popfile = popfile;
		this.processState = processState;
		this.sexCd = sexCd;
		this.neuterYn = neuterYn;
		this.specialMark = specialMark;
		this.careNm = careNm;
		this.careTel = careTel;
		this.careAddr = careAddr;
		this.orgNm = orgNm;
		this.chargeNm = chargeNm;
		this.officetel = officetel;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getDesertionNo() {
		return desertionNo;
	}


	public void setDesertionNo(String desertionNo) {
		this.desertionNo = desertionNo;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
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


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
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


	public String getPopfile() {
		return popfile;
	}


	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}


	public String getProcessState() {
		return processState;
	}


	public void setProcessState(String processState) {
		this.processState = processState;
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


	public String getSpecialMark() {
		return specialMark;
	}


	public void setSpecialMark(String specialMark) {
		this.specialMark = specialMark;
	}


	public String getCareNm() {
		return careNm;
	}


	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}


	public String getCareTel() {
		return careTel;
	}


	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}


	public String getCareAddr() {
		return careAddr;
	}


	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}


	public String getOrgNm() {
		return orgNm;
	}


	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}


	public String getChargeNm() {
		return chargeNm;
	}


	public void setChargeNm(String chargeNm) {
		this.chargeNm = chargeNm;
	}


	public String getOfficetel() {
		return officetel;
	}


	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}


	public DatasetDto() {}
}
