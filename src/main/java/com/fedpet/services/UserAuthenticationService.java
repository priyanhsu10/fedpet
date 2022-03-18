package com.fedpet.services;

import com.fedpet.Interfaces.IUserAuthenticationService;
import com.fedpet.dtos.*;
import com.fedpet.entities.User;
import com.fedpet.repositories.UserRepository;
import com.fedpet.utils.IMapper;
import com.fedpet.utils.IValidator;
import com.fedpet.utils.JwtHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthenticationService implements IUserAuthenticationService {
    private final UserRepository userRepository;
    private final IValidator validator;
    private final IMapper mapper;
    private final JwtHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;

    public UserAuthenticationService(UserRepository userRepository, IValidator iValidator, IMapper mapper, JwtHelper jwtHelper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        validator = iValidator;
        this.mapper = mapper;
        this.jwtHelper = jwtHelper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegistrationDto registrationDto) {
        validator.ValidateRegistration(registrationDto);
        User user=mapper.toUser(registrationDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public AuthenticationResult authenticate(AuthInputDto authInputDto) {
        //username exist
        Optional<User> optUser = userRepository.findByUsername(authInputDto.getUserName());
            if(optUser.isEmpty()){
                AuthenticationResult result= new AuthenticationResult();
                result.setError("username/password incorrect");
                return result;
            }

            User user= optUser.get();
            //validate password
        if(!passwordEncoder.matches(authInputDto.getPassword(),user.getPassword())){
            AuthenticationResult result= new AuthenticationResult();
            result.setError("username/password incorrect");
            return result;
        }

            var result=  new AuthenticationResult();
            var successResult= new SuccessResult();
            successResult.setFirstName(user.getFirstname());
            successResult.setFirstName(user.getLastname());
            successResult.setUserName(user.getUsername());
            successResult.setJwtToken(jwtHelper.getToken(user));
            result.setSuccessResult(successResult);
            result.setIsSuccessAuthentication(true);
            return result;
        };

}
