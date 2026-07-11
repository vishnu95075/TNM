package com.tns.user.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Objects;

@Service
public class ImageUploadService {

    private final Cloudinary cloudinary;

    public ImageUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new RuntimeException("Photo file is empty");
        }
        if(!Objects.requireNonNull(file.getContentType()).startsWith("image/")){
            throw new RuntimeException("Only images allowed");
        }
        Map uploadResult = cloudinary.uploader()
                .upload(
                        file.getBytes(),
                        ObjectUtils.asMap(
                                "profile", "images"
                        )
                );

        return uploadResult
                .get("secure_url")
                .toString();
    }
}
