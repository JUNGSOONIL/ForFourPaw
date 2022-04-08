package com.ssafy.FFP.Dto;

public class AnalysisDto {
    private String code;
    private String name;
    private double value;

    public AnalysisDto() { }

    public AnalysisDto(String key, double value) {
        this.name = key;
        this.value = value;
    }

    public AnalysisDto(String key, double value, String code) {
        this.name = key;
        this.value = value;
        this.code = code;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getKey() { return name; }
    public void setKey(String key) { this.name = key; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    @Override
    public String toString() {
        return "AnalysisDto{" +
                "key='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
