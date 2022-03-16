package com.fedpet.utils;

import com.fedpet.dtos.UserRegistrationDto;
import com.fedpet.expeptions.PetFedException;
import com.fedpet.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class Validator implements IValidator{
    private UserRepository userRepository;

    public Validator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  void ValidateRegistration(UserRegistrationDto userRegistrationDto){

      if(  userRepository.existsByUsername(userRegistrationDto.getUserName())){
          throw new PetFedException("Username already Exist");
      }
    }
}
