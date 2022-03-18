package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserRegistrationDto {
    @NotBlank
    @Size(max = 32,min = 3)
    private String firstname;
    @NotBlank
    @Size(max = 32,min = 3)
    private String username;
    @NotBlank
    @Size(max = 32,min = 3)
    private String lastname;

    private UserType userType;
    @NotBlank
    @Size(max = 13,min = 10)
    private String mobileNumber;
    @Size(max = 32,min = 4)
    private String password;
    @Email
    @NotBlank
    private String email;

    private UserAddressDto address;
}
