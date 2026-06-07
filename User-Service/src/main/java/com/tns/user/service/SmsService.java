package com.tns.user.service;

public class SmsService {
    public void sendOtp(String mobileNumber, String otp) {
        System.out.println("OTP was send on "+mobileNumber+" otp is :"+otp);
    }
}
