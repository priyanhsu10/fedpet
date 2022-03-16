package com.fedpet.entities;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class EventLocation {
    private String country;
    private String city;
    private UserType state;
    private String area;
    private String Address;
    //get location from map longitude and latitude and generate above details
    private double longitude;
    private double latitude;

}
