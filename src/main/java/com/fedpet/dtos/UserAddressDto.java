package com.fedpet.dtos;

import com.fedpet.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAddressDto {
    private int id;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private UserType state;
    @NotBlank
    private String area;
    @NotNull
    private double longitude;
    @NotNull
    private double latitude;


}
