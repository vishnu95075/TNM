package com.tns.auth.controller;

import com.tns.auth.dto.AuthResponse;
import com.tns.auth.dto.LoginRequest;
import com.tns.auth.dto.LoginResponseDTO;
import com.tns.auth.dto.RegisterRequest;
import com.tns.auth.service.impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {
        AuthResponse authResponse = authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).header("Authentication", authResponse.getToken()).body(authResponse);
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout() {

        return ResponseEntity.ok(
                authService.logout()
        );
    }

}
