package com.tns.post.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


public class PostModel {

    private Long id;

    private String content;

    private String userName;

    private LocalDateTime createdAt;


    transient private List<UserModel> users;

}
