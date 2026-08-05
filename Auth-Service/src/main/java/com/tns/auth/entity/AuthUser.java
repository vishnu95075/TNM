package com.tns.auth.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "auth_user_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String authId;

    @Column(unique = true, nullable = false)
    private String username;

//    @Column(nullable = false)
    private String fullName;

//    @Column(nullable = true)
    private Date dob;

    @Column(nullable = false)
    private String email;

    @Column(unique = true)
    private String contactNo;

    @Column(nullable = false)
    private String password;

    private String role;
}
