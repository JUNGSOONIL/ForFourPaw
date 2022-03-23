package com.ssafy.FFP.Dto;

public class AnalysisResultDto {

    private int number;

    public AnalysisResultDto()  { }
    public AnalysisResultDto(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AnalysisResultDto{" +
                "number=" + number +
                '}';
    }
}
