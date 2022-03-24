package com.ssafy.FFP.Dto;

import java.util.List;

public class AnalysisResultDto {

    private List<AnalysisDto> list;
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

    public List<AnalysisDto> getList() { return list; }
    public void setList(List<AnalysisDto> list) { this.list = list; }

    @Override
    public String toString() {
        return "AnalysisResultDto{" +
                "number=" + number +
                '}';
    }
}
