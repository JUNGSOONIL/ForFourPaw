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

    // 월별 통게
    private List<AnalysisDto> datelist;
    public List<AnalysisDto> getDatelist() {
        return datelist;
    }
    public void setDatelist(List<AnalysisDto> datelist) {
        this.datelist = datelist;
    }

    // 동물별 통계
    private List<AnalysisDto> kindlist;
    public List<AnalysisDto> getKindlist() {
        return kindlist;
    }
    public void setKindlist(List<AnalysisDto> kindlist) {
        this.kindlist = kindlist;
    }

    // 품종별 통계
    private List<AnalysisDto> kindlist2;
    public List<AnalysisDto> getKindlist2() {
        return kindlist2;
    }
    public void setKindlist2(List<AnalysisDto> list) {
        this.kindlist2 = list;
    }

    // 지역별 통계
    private List<AnalysisDto> regionlist;
    public List<AnalysisDto> getRegionlist() { return regionlist; }
    public void setRegionlist(List<AnalysisDto> regionlist) { this.regionlist = regionlist; }

    // 년도별 통계
    private List<AnalysisDto> yearlist;
    public List<AnalysisDto> getYearlist() { return yearlist; }
    public void setYearlist(List<AnalysisDto> yearlist) { this.yearlist = yearlist; }

    @Override
    public String toString() {
        return "AnalysisResultDto{" +
                "number=" + number +
                '}';
    }
}
