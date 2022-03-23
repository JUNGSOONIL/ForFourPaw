package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dao.ShelnimalDao;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelnimalServiceImpl implements ShelnimalService {

    @Autowired
    ShelnimalDao shelnimalDao;

    @Override
    public ShelnimalDto select(int no) {
        ShelnimalDto shelnimalDto = shelnimalDao.select(no);
        return shelnimalDto;
    }

    @Override
    public List<ShelnimalDto> list(String sdt) {
        List<ShelnimalDto> shelnimalDtos = shelnimalDao.list(sdt);
        return shelnimalDtos;
    }

    @Override
    public List<ShelnimalDto> match(int userNo) {
        List<ShelnimalDto> shelnimalDtos = shelnimalDao.match(userNo);
        return shelnimalDtos;
    }

    @Override
    public List<ShelnimalDto> find(SearchDto searchDto) {
        return shelnimalDao.find(searchDto);
    }
}
