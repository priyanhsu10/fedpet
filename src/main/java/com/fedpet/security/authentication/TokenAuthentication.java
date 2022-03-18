package com.fedpet.security.authentication;

import com.fedpet.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class TokenAuthentication extends UsernamePasswordAuthenticationToken {
    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    private  UserInfo user;
    public TokenAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public TokenAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
    public TokenAuthentication( Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,UserInfo user) {
        super(principal, credentials, authorities);
        this.user=user;
    }
}
