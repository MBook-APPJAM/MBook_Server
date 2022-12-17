package com.example.mbook.global.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import com.example.mbook.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class S3Upload {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final UserFacade userFacade;
    private final AmazonS3 amazonS3;
    private final UserRepository userRepository;

    public String uploadImage(MultipartFile multipartFile){
        return upload(multipartFile);
    }

    public void updateUser(MultipartFile multipartFile){
        User user = userFacade.getCurrentUser();
        if(user.getImageUrl() != null){
            amazonS3.deleteObject(bucket,user.getImageUrl());
        }
        user.userProfileChange(upload(multipartFile));
        userRepository.save(user);
    }

    public void delUser(User user){
        if(user.getImageUrl() != null){
            amazonS3.deleteObject(bucket,user.getImageUrl());
        }
    }

    public String getImageUrl(String s3FileName){
        return amazonS3.getUrl(bucket, s3FileName).toString();
    }

    private String upload(MultipartFile multipartFile){
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        ObjectMetadata objMeta = new ObjectMetadata();
        try {
            objMeta.setContentLength(multipartFile.getInputStream().available());
            amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s3FileName;
    }
}
