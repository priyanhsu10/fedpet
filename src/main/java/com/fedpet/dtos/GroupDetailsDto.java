package com.fedpet.dtos;

import com.fedpet.entities.Group;
import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDetailsDto {
    private int id ;
    private  String groupName;
    private Set<GroupUserDto> members= new HashSet<>();
    private UserType groupUserType;
    private LocalDateTime addedAt;
    private boolean isActive;
    private  Set<EventDto> events= new HashSet<>();

}
