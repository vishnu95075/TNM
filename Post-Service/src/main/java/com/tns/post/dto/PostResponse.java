package com.tns.post.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponse {

    private Long id;

    private Long userId;

    private String content;

    private String mediaUrl;

    private String mediaType;

    private Long views;

    private Long likes;

    private String createdAt;
}
