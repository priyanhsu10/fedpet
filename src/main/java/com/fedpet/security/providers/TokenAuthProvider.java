package com.fedpet.security.providers;

import com.fedpet.security.authentication.TokenAuthentication;
import com.fedpet.security.authentication.UserInfo;
import com.fedpet.utils.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthProvider implements AuthenticationProvider {
    private final JwtHelper jwtHelper;
    Logger logger = LoggerFactory.getLogger(TokenAuthProvider.class);

    public TokenAuthProvider(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token= authentication.getName();
        try{
            UserInfo userInfo= jwtHelper.validate(token);
            ((TokenAuthentication) authentication).setUser(userInfo);
            return  authentication;

        }
        catch (Exception exception){
            logger.error(exception.getLocalizedMessage(),exception);
            return  null;
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
