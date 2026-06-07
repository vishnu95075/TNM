package com.tns.user.security;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class MobileAuthenticationToken extends AbstractAuthenticationToken {
    private final Object principal; // Mobile Number
    private Object credentials;     // OTP

    // Constructor for unauthenticated requests
    public MobileAuthenticationToken(Object principal, Object credentials) {
        super((Collection<? extends GrantedAuthority>) null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    // Constructor for authenticated requests
    public MobileAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() { return this.credentials; }

    @Override
    public Object getPrincipal() { return this.principal; }
}

