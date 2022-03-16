package com.fedpet.services;

import com.fedpet.Interfaces.IUserService;
import com.fedpet.dtos.UserDto;
import com.fedpet.repositories.UserRepository;
import com.fedpet.utils.IMapper;
import com.fedpet.utils.IValidator;
import com.fedpet.utils.JwtHelper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService
{
    private final UserRepository userRepository;
    private final IValidator validator;
    private final IMapper mapper;
    private final JwtHelper jwtHelper;

    public UserService(UserRepository userRepository, IValidator iValidator, IMapper mapper, JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        validator = iValidator;
        this.mapper = mapper;
        this.jwtHelper = jwtHelper;
    }
    @Override
    public UserDto getUser(int userId) {
        return null;
    }
}
