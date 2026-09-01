package com.tns.post.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Objects;

@Service
public class MediaUploadService {
    private final Cloudinary cloudinary;

    public MediaUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    public String uploadMedia(MultipartFile file) throws Exception {
        Map<?,?> uploadResult = null;
        if (file.isEmpty()) {
            throw new RuntimeException("Video file is empty");
        }

        if (Objects.requireNonNull(file.getContentType()).startsWith("video/")) {
            uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "video"
                    )
            );
        } else if (Objects.requireNonNull(file.getContentType()).startsWith("image/")) {
            uploadResult = cloudinary.uploader()
                    .upload(
                            file.getBytes(),
                            ObjectUtils.asMap(
                                    "resource_type", "image"
                            )
                    );

        } else throw new RuntimeException("Only image/video files are allowed");
        System.out.println(uploadResult.toString());
        return uploadResult.get("secure_url").toString();
    }
}
