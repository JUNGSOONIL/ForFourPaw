package com.ssafy.FFP.Service;

import com.ssafy.FFP.Dto.S3Dto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3Service {

    public List<Integer> uploadFile(List<MultipartFile> multipartFile);
    public String uploadFileReturnURL(int no, MultipartFile multipartFile);
    public void deleteFile(String fileName);
    public S3Dto select(int no);
    public S3Dto selectByName(String imgName);
    public S3Dto selectByLink(String imgLink);
}
