package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.Data;

@Data
public class GroupUserDto {
    private String firstname;
    private String lastname;
    private UserType primaryUserType;
    private  int id;
}
