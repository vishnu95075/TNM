package com.tns.post.dto;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePostDto {

    private String content;

    private List<String> mediaUrl;

    private List<String> tag;

}
