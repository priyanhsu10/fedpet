package com.fedpet.entities;

import com.fedpet.dtos.GroupInputDto;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class GroupLocation {
    private String country;
    private String city;
    private String state;
    private String area;

    public GroupLocation build(GroupInputDto inputDto) {
        this.country=inputDto.getCountry();
        this.city=inputDto.getCity();
        this.state=inputDto.getState();
        this.area=inputDto.getArea();
        return this;
    }
}
