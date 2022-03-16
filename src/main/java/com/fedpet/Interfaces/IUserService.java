package com.fedpet.Interfaces;

import com.fedpet.dtos.UserDto;

public interface IUserService {

    UserDto getUser(int userId);
}
