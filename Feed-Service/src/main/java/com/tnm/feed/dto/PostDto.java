package com.tnm.feed.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDto {

    private String id;

    private String userId;

    private String content;

    private List<String> mediaUrl;

    private List<String> tag;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
