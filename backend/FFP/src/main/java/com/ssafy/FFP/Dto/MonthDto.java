package com.ssafy.FFP.Dto;

public class MonthDto {
	String processState;
	int count;
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MonthDto [processState=" + processState + ", count=" + count + "]";
	}
	public MonthDto() {}
	public MonthDto(String processState, int count) {
		super();
		this.processState = processState;
		this.count = count;
	}
	
}
