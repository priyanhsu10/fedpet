package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInputDto {
    private int id ;
    private  String groupName;
    private String country;
    private String city;
    private String state;
    private String area;

}
