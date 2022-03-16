package com.fedpet.utils;

import com.fedpet.dtos.UserRegistrationDto;

public interface IValidator {
    void ValidateRegistration(UserRegistrationDto userRegistrationDto);
}
