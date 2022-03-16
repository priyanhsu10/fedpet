package com.fedpet.Interfaces;

import com.fedpet.dtos.AuthInputDto;
import com.fedpet.dtos.AuthenticationResult;
import com.fedpet.dtos.UserRegistrationDto;

public interface IUserAuthenticationService {
    void register(UserRegistrationDto user);
    AuthenticationResult authenticate(AuthInputDto authInputDto);
}
