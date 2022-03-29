package com.ssafy.FFP.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ssafy.FFP.Dao.S3Dao;
import com.ssafy.FFP.Dto.S3Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    @Autowired
    S3Dao s3Dao;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public List<Integer> uploadFile(List<MultipartFile> multipartFile) {
        List<String> fileNameList = new ArrayList<>();
        List<String> fileURLList = new ArrayList<>();

        // forEach 구문을 통해 multipartFile로 넘어온 파일들 하나씩 fileNameList에 추가
        multipartFile.forEach(file -> {
            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            String fileUrl = "";
            try(InputStream inputStream = file.getInputStream()) {
                amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                fileUrl = amazonS3.getUrl(bucket, fileName).toString();
            } catch(IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
            }

            fileNameList.add(fileName);
            fileURLList.add(fileUrl);
        });

        List<Integer> Ids = new ArrayList<>();
        for (int i = 0; i < fileNameList.size(); i++) {
            S3Dto s3Dto = new S3Dto();
            s3Dto.setImgName(fileNameList.get(i));
            s3Dto.setImgLink(fileURLList.get(i));
            s3Dao.flushFile(s3Dto);
            Ids.add(s3Dto.getNo());
        }
        return Ids;
    }

    public String uploadFileReturnURL(int no, MultipartFile file) {
       
        // forEach 구문을 통해 multipartFile로 넘어온 파일들 하나씩 fileNameList에 추가
        String fileName = createFileName(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        String fileUrl = "";
        try(InputStream inputStream = file.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            fileUrl = amazonS3.getUrl(bucket, fileName).toString();
        } catch(IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }
        
        if(fileName != null) {
        	S3Dto s3Dto = new S3Dto();
            s3Dto.setImgName(fileName);
            s3Dto.setImgLink(fileUrl);
            int result = s3Dao.updateimg(no, s3Dto.getImgLink());
            String URLs = s3Dto.getImgLink();
            if(result == 1)
            	return URLs;
        }
        return null;
    }
    
    public void deleteFile(String fileName) {

        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
        s3Dao.deleteFile(fileName);
    }

    @Override
    public S3Dto select(int no) {
        S3Dto img = s3Dao.select(no);
        return img;
    }

    @Override
    public S3Dto selectByName(String imgName) {
        S3Dto img = s3Dao.selectByName(imgName);
        return img;
    }

    @Override
    public S3Dto selectByLink(String imgLink) {
        S3Dto img = s3Dao.selectByLink(imgLink);
        return img;
    }

    private String createFileName(String fileName) { // 먼저 파일 업로드 시, 파일명을 난수화하기 위해 random으로 돌립니다.
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    private String getFileExtension(String fileName) { // file 형식이 잘못된 경우를 확인하기 위해 만들어진 로직이며, 파일 타입과 상관없이 업로드할 수 있게 하기 위해 .의 존재 유무만 판단하였습니다.
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
    }

}
