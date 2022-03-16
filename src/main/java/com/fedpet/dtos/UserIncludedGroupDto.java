package com.fedpet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserIncludedGroupDto {
    private  int groupId;
    private  String GroupName;
}
