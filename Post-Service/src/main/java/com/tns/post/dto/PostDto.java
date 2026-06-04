package com.tns.post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long userId;

    private String content;

    // Image/Video stored in S3, Cloudinary, etc.
    private String mediaUrl;

}
