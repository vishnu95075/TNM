package com.tns.user.controller;

import com.tns.user.service.OtpService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final OtpService otpService;

    public AuthController(AuthenticationManager authenticationManager, OtpService otpService) {
        this.authenticationManager = authenticationManager;
        this.otpService = otpService;
    }
/*
This is use in future
    // Endpoint 1: Send OTP to Mobile
    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String mobileNumber) {
        System.out.println("send otp "+mobileNumber);
        otpService.generateAndSendOtp(mobileNumber);
        return ResponseEntity.ok("OTP sent successfully to " + mobileNumber);
    }
    // Endpoint 2: Verify OTP and Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String mobileNumber, @RequestParam String otp) {
        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(mobileNumber, otp);

        // Triggers MobileAuthenticationProvider
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Generate and return your session token (like a JWT) here
        return ResponseEntity.ok("Login Successful! Authorities: " + authentication.getAuthorities());
    }

 */
}

