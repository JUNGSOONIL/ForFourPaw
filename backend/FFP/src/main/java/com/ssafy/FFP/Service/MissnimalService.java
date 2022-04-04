package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dto.MissnimalDto;
import com.ssafy.FFP.Dto.S3Dto;
import com.ssafy.FFP.Dto.SearchDto;

import java.util.List;

public interface MissnimalService {
    public MissnimalDto select(int no);
    public List<MissnimalDto> selectByUser(int no);
    public int create(MissnimalDto missnimalDto, S3Dto s3Dto);
    public int update(MissnimalDto missnimalDto, S3Dto s3Dto);
    public int delete(int no);
    public List<MissnimalDto> list(int offset, int limit);
    public List<MissnimalDto> match(int userNo);
    public List<MissnimalDto> find(SearchDto searchDto);

}
