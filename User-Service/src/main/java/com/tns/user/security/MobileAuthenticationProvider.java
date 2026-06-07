package com.tns.user.security;
import com.tns.user.service.CustomUserDetailsService;
import com.tns.user.service.OtpService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MobileAuthenticationProvider implements AuthenticationProvider {

    // Inject your services to fetch user data and verify OTP cache
    private final OtpService otpService;
    private final CustomUserDetailsService userDetailsService;

    public MobileAuthenticationProvider(OtpService otpService, CustomUserDetailsService userDetailsService) {
        this.otpService = otpService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String mobileNumber = (String) authentication.getPrincipal();
        String otp = (String) authentication.getCredentials();

        // 1. Validate OTP
        if (!otpService.isValidOtp(mobileNumber, otp)) {
            throw new BadCredentialsException("Invalid or expired OTP");
        }

        // 2. Fetch user and their roles (Authorization authorities)
        UserDetails user = userDetailsService.loadUserByMobileNumber(mobileNumber);

        // 3. Return fully populated, authenticated token
        return new MobileAuthenticationToken(user, otp, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

