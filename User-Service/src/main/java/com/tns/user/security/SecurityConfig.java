package com.tns.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity // Enables @PreAuthorize role checks
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configure(http)).authorizeHttpRequests(req-> req.anyRequest().permitAll())
//                .http.authorizeHttpRequests(auth -> authorities
//                        .requestMatchers("/api/auth/**", "/api/auth/login/mobile").permitAll()
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // URL-level authorization
//                        .anyRequest().authenticated()
//                )

                .formLogin(withDefaults())
                        .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /*

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        UserDetails user1  = User.withUsername("vishnu").password("{noop}0000").authorities("admin").build();
        UserDetails user2  = User.withUsername("ravi").password("{noop}0000").authorities("admin").build();
        UserDetails user3  = User.withUsername("admin").password("{bcrypt}$2a$12$RDrfTh2YcMFxS7m8X8/O/eVZ/k8XN.TNrWlLHc3dcjKFqN03Y.KJS").authorities("admin").build();
        return new InMemoryUserDetailsManager(user1,user2,user3);

    }

     */
}

