package com.tns.post.model;

import java.time.LocalDateTime;
import java.util.List;


public class PostModel {

    private Long id;

    private String content;

    private String userName;

    private LocalDateTime createdAt;


    transient private List<UserModel> users;

}
