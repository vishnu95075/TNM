package com.tns.user.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_demo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    private String userName;
    private String name;
    private String password;
    private String profilePicUrl;

    private List<String> blockedUser;
    private List<String> followUser;
    private List<String> followerUser;


}

