package com.tns.auth.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterRequest {

    private String fullName;
    private Date dob;
    private String username;
    private String email;
    private String password;
}
