package com.tns.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Enables @PreAuthorize role checks
public class SecurityConfig {

    private final MobileAuthenticationProvider mobileAuthenticationProvider;

    public SecurityConfig(MobileAuthenticationProvider mobileAuthenticationProvider) {
        this.mobileAuthenticationProvider = mobileAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(mobileAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configure(http)).authorizeHttpRequests(req-> req.anyRequest().permitAll());
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**", "/api/auth/login/mobile").permitAll()
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // URL-level authorization
//                        .anyRequest().authenticated()
//                )
//                .authenticationManager(authenticationManager);

        return http.build();
    }
}

