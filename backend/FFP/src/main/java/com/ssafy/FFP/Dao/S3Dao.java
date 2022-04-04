package com.ssafy.FFP.Dao;

import com.ssafy.FFP.Dto.S3Dto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface S3Dao {
    public int flushFile(S3Dto s3Dto);
    public int updateimg(@Param(value = "no") int no,@Param(value = "imgLink") String imgLink);
    public void deleteFile(String imgName);
    public void deleteByNo(int no);

    public S3Dto select(int no);
    public S3Dto selectByName(String imgName);
    public S3Dto selectByLink(String imgLink);
}
