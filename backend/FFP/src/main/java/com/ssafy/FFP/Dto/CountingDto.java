package com.ssafy.FFP.Dto;

import java.util.List;

public class CountingDto {
    private int allCount;
    private List<ShelnimalDto> shelnimalDtos;
    private List<MissnimalDto> missnimalDtos;

    public CountingDto() {
    }

    public CountingDto(int allCount, List<ShelnimalDto> shelnimalDtos, List<MissnimalDto> missnimalDtos) {
        this.allCount = allCount;
        this.shelnimalDtos = shelnimalDtos;
        this.missnimalDtos = missnimalDtos;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public List<ShelnimalDto> getShelnimalDtos() {
        return shelnimalDtos;
    }

    public void setShelnimalDtos(List<ShelnimalDto> shelnimalDtos) {
        this.shelnimalDtos = shelnimalDtos;
    }

    public List<MissnimalDto> getMissnimalDtos() {
        return missnimalDtos;
    }

    public void setMissnimalDtos(List<MissnimalDto> missnimalDtos) {
        this.missnimalDtos = missnimalDtos;
    }
}
