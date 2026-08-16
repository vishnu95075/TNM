package com.tns.post.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMsgDto {
    private String message;
    private boolean success;
}
