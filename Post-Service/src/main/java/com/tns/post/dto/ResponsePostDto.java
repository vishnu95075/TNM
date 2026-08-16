package com.tns.post.dto;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePostDto {

    private String content;

    private String mediaUrl;

    private String mediaType;

    private List<String> tag;

}
