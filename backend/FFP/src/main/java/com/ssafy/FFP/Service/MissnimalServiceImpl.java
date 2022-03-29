package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dao.MissnimalDao;
import com.ssafy.FFP.Dao.S3Dao;
import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.S3Dto;
import com.ssafy.FFP.Dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissnimalServiceImpl implements MissnimalService{

    @Autowired
    MissnimalDao missnimalDao;

    @Autowired
    S3Dao s3Dao;

    @Override
    public MissnimalDto select(int no) {
        MissnimalDto missnimalDto = missnimalDao.select(no);
        return missnimalDto;
    }

    @Override
    public int create(MissnimalDto missnimalDto, S3Dto img) {
        missnimalDto.setProfile(img.getImgLink());
        int result = missnimalDao.create(missnimalDto);
        missnimalDao.relation(img.getNo(), result);
        return result;
    }

    @Override
    public int update(MissnimalDto missnimalDto, S3Dto img) {
        if(img != null) {
            S3Dto latest = s3Dao.selectByLink(missnimalDto.getProfile());
            s3Dao.deleteFile(latest.getImgName());
            s3Dao.deleteByNo(latest.getNo());
            missnimalDto.setProfile(img.getImgLink());
        }
        MissnimalDto raw = missnimalDao.select(missnimalDto.getNo());
        missnimalDto.setProfile(raw.getProfile());
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
