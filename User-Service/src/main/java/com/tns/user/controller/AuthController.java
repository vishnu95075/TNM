package com.tns.user.controller;

import com.tns.user.entity.UserProfile;
import com.tns.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @PostMapping("/login")
    public UserDetails loadUserByUsername(@RequestParam String userName) throws UsernameNotFoundException {
        UserProfile user = userRepository.findByUserName(userName);
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserName()).password(user.getPassword()).authorities("ADMIN").build();
    }
}
