package com.fedpet.dtos;

import com.fedpet.entities.EventLocation;
import com.fedpet.entities.UserType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventInputDto {
    private MultipartFile imageOrVideo;
    private String country;
    private String city;
    private UserType state;
    private String area;
    private String Address;
    //get location from map longitude and latitude and generate above details
    private double longitude;
    private double latitude;
    private LocalDate eventDate;
    private LocalTime eventTime;
}
