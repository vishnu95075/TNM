package com.tns.post.dto;
import lombok.Data;

@Data
public class CreatePostRequest {

    private String content;

    private String mediaUrl;

    private String mediaType;
}
