package com.fedpet.dtos;

import com.fedpet.entities.UserGroup;
import com.fedpet.entities.UserType;
import lombok.Data;

@Data
public class GroupUserDto {
    private String firstname;
    private String lastname;
    private UserType primaryUserType;
    private  int id;

    public static GroupUserDto build(UserGroup userGroup) {
      var groupUserDto=  new GroupUserDto();
        groupUserDto.setId(userGroup.getUser().getId());
        groupUserDto.setLastname(userGroup.getUser().getUsername());
        groupUserDto.setLastname(userGroup.getUser().getLastname());
        groupUserDto.setPrimaryUserType(userGroup.getUserType());
        return groupUserDto;
    }
}
