package com.ssafy.FFP.Service;

import java.util.List;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;

public interface ShelnimalService {

    public ShelnimalDto select(int no);
    public List<ShelnimalDto> list(int sdt);
    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
    public List<DatasetDto> mainList();
}
