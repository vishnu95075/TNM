package com.tns.user.dto;

import lombok.Data;

@Data
public class VerifyOtpRequestDto {

    private String mobileNumber;
    private String otp;
}
