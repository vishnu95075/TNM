package com.tns.user.service;

import com.tns.user.entity.User;
import com.tns.user.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Custom method to fetch user identities using a mobile number index.
     */
    public org.springframework.security.core.userdetails.UserDetails loadUserByMobileNumber(String mobileNumber)
            throws UsernameNotFoundException {

        // 1. Fetch user records from the database
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with mobile number: " + mobileNumber));

        // 2. Map database enums to Spring Security authorities
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        // 3. Return a standard Spring Security User wrapper object
        // Note: Password field is blank ("") because authentication relies entirely on OTP codes
        return new org.springframework.security.core.userdetails.User(
                user.getMobileNumber(),
                "",
                user.isActive(), // enabled
                true,            // accountNonExpired
                true,            // credentialsNonExpired
                true,            // accountNonLocked
                authorities
        );
    }
}

