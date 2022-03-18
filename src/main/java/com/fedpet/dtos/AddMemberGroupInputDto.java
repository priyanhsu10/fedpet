package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMemberGroupInputDto {
    private int userId;
    private int groupId;
    private UserType userType;
}
