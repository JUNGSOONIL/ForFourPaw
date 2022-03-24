package com.ssafy.FFP.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3Service {

    public List<Integer> uploadFile(List<MultipartFile> multipartFile);
    public String uploadFileReturnURL(int no, MultipartFile multipartFile);
    public void deleteFile(String fileName);
}
