package com.ssafy.FFP.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import com.ssafy.FFP.Dto.ViewStoreDto;

@Mapper
public interface ShelnimalDao {

    public ShelnimalDto select(String no);
    public int insert(ShelnimalDto data);
    public List<ShelnimalDto> list(@Param("sdt") int sdt,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);

    public List<ShelnimalDto> match(int userNo);
    public List<ShelnimalDto> find(SearchDto searchDto);
    public List<DatasetDto> mainList(String processState);
    public List<String> searchList(String kind);
    public Integer userCount();
    public String[] userInfo();
    public String[] userItem(String no);
    public List<DatasetDto> mainListLogin(List<String> list);
    public int viewStore(ViewStoreDto viewStoreDto);
}
