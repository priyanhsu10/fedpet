package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupDto {

    private long id;
    private Set<GroupUserDto> members= new HashSet<>();
    private UserType GroupUserType;
    private LocalDateTime addedAt;
    private boolean isActive;
}
