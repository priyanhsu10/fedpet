package com.fedpet.services;

import com.fedpet.Interfaces.IUserDetails;
import com.fedpet.security.authentication.TokenAuthentication;
import com.fedpet.security.authentication.UserInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetails implements IUserDetails {
    @Override
    public UserInfo get() {
        return ((TokenAuthentication)SecurityContextHolder.getContext().getAuthentication()).getUser();
    }
}
