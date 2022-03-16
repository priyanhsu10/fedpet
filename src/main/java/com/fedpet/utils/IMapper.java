package com.fedpet.utils;

import com.fedpet.dtos.UserDto;
import com.fedpet.dtos.UserRegistrationDto;
import com.fedpet.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapper {
    User toUser(UserRegistrationDto userRegistrationDto);
    UserDto toUserDto(User user);
}
