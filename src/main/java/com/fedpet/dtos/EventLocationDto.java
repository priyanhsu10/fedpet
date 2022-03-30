package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventLocationDto {
    private String country;
    private String city;
    private String state;
    private String area;
    private String Address;
    //get location from map longitude and latitude and generate above details
    private double longitude;
    private double latitude;
}
