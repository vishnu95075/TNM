package com.tns.user.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_demo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userName;
    private String name;
    private String password;
    private String profilePicUrl;

    private List<String> blockedUser;
    private List<String> followUser;
    private List<String> followerUser;


}

