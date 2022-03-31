package com.ssafy.FFP.Dto;

public class AnalysisDto {
    private String key;
    private double value;

    public AnalysisDto() { }

    public AnalysisDto(String key, double value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    @Override
    public String toString() {
        return "AnalysisDto{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
