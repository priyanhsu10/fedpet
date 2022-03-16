package com.fedpet.entities;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class GroupLocation {
    private String country;
    private String city;
    private UserType state;
    private String area;
}
