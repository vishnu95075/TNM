package com.tnm.feed.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
public class PostEntity {

    @Id
    private String id;

//    private String userId;
//
//
//    private String content;
//
//    private List<String> mediaUrl;
//
//    private List<String> tag;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
}
