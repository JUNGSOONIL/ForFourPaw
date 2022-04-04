package com.ssafy.FFP.Service;

import java.util.List;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import com.ssafy.FFP.Dto.ViewStoreDto;

public interface ShelnimalService {

    public ShelnimalDto select(String no);
    public int insert(ShelnimalDto data);
    public List<ShelnimalDto> list(int sdt, int offset, int limit);
    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
    public List<DatasetDto> mainList();
    public List<DatasetDto> mainListLogin(String no);
    public List<String> searchList(String kind);
    public int viewStore(ViewStoreDto viewStoreDto);
}
