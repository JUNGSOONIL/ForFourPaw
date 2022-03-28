package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;

import java.util.List;

public interface ShelnimalService {

    public ShelnimalDto select(int no);
    public List<ShelnimalDto> list(int sdt);
    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
}
