package com.tns.auth.service.impl;

import com.tns.auth.dto.AuthResponse;
import com.tns.auth.dto.LoginRequest;
import com.tns.auth.dto.RegisterRequest;
import com.tns.auth.entity.AuthUser;
import com.tns.auth.repository.UserRepository;
import com.tns.auth.security.JwtService;
import com.tns.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {

        AuthUser user = AuthUser.builder()
                .username(request.getUsername())
                .fullName(request.getFullName())
                .dob(request.getDob())
                .email(request.getEmail())
                .password(
                        encoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();

        repository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        AuthUser user = repository.findByUsername(
                request.getUsername()).orElseThrow();

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }

    @Override
    public String logout() {
        return "Logged out successfully";
    }

}