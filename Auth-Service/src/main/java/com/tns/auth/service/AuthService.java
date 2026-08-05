package com.tns.auth.service;

import com.tns.auth.dto.AuthResponse;
import com.tns.auth.dto.LoginRequest;
import com.tns.auth.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    String logout();

}
