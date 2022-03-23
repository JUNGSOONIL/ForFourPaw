package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dao.MissnimalDao;
import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissnimalServiceImpl implements MissnimalService{

    @Autowired
    MissnimalDao missnimalDao;

    @Override
    public MissnimalDto select(int no) {
        MissnimalDto missnimalDto = missnimalDao.select(no);
        return missnimalDto;
    }

    @Override
    public int create(MissnimalDto missnimalDto) {
        int result = missnimalDao.create(missnimalDto);
        return result;
    }

    @Override
    public int update(MissnimalDto missnimalDto) {
        int result = missnimalDao.update(missnimalDto);
        return result;
    }

    @Override
    public int delete(int no) {
        int result = missnimalDao.delete(no);
        return result;
    }

    @Override
    public List<MissnimalDto> list(String sdt) {
        List<MissnimalDto> missnimalDtos = missnimalDao.list(sdt);
        return missnimalDtos;
    }

    @Override
    public List<MissnimalDto> match(int userNo) {
        List<MissnimalDto> missnimalDtos = missnimalDao.match(userNo);
        return missnimalDtos;
    }

    @Override
    public List<MissnimalDto> find(SearchDto searchDto) {
        List<MissnimalDto> missnimalDtos = missnimalDao.find(searchDto);
        return missnimalDtos;
    }
}
