package com.tns.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestPostDto {
    private String userId;

    private String content;

    private List<String> mediaUrl;
    private List<String> tag;

}
