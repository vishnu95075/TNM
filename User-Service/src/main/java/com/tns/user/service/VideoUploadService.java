package com.tns.user.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class VideoUploadService {

    private final Cloudinary cloudinary;

    public VideoUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    public String uploadVideo(MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new RuntimeException("Video file is empty");
        }

        if (!file.getContentType().startsWith("video/")) {
            throw new RuntimeException("Only video files are allowed");
        }


        Map uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "resource_type", "video",
                        "folder", "tnm-videos"
                )
        );


        return uploadResult.get("secure_url").toString();
    }
}
