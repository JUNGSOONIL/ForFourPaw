package com.ssafy.FFP.Dto;

public class ViewStoreDto {
	private String no;
	private String desertionNo;
	
	public ViewStoreDto() {}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDesertionNo() {
		return desertionNo;
	}
	public void setDesertionNo(String desertionNo) {
		this.desertionNo = desertionNo;
	}
	public ViewStoreDto(String no, String desertionNo) {
		super();
		this.no = no;
		this.desertionNo = desertionNo;
	}
	@Override
	public String toString() {
		return "ViewStoreDto [no=" + no + ", desertionNo=" + desertionNo + "]";
	}
	
	
}
