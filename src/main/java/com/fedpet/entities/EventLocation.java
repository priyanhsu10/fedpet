package com.fedpet.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Data
public class EventLocation {
    @NotBlank
    private String country;
    @NotBlank

    private String city;
    @NotBlank

    private String state;
    @NotBlank

    private String area;
    @NotBlank

    private String Address;
    //get location from map longitude and latitude and generate above details


    private Double longitude;


    private Double latitude;

}
