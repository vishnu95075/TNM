package com.tns.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestPostDto {
    private String userId;

    private String content;

    // Image/Video stored in S3, Cloudinary, etc.
    private String mediaUrl;
    private List<String> tag;

}
