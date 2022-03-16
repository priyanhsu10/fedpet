package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserRegistrationDto {
    @NotBlank
    @Max(32)
    @Min(3)
    private String firstname;
    @NotBlank
    @Max(32)
    @Min(3)
    private String userName;
    @NotBlank
    @Max(32)
    @Min(3)
    private String lastname;

    private UserType userType;
    @NotBlank
    @Max(13)
    @Min(10)
    private String mobileNumber;
    @Max(32)
    @Min(4)
    private String password;
    @Email
    @NotBlank
    private String email;

    private UserAddressDto address;
}
