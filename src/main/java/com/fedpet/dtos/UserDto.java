package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstname;
    private String lastname;
    private UserType userType;
    private String mobileNumber;
    private String password;
    private String email;
    private UserAddressDto address;
    private List<UserIncludedGroupDto> groupDtoList;
}
