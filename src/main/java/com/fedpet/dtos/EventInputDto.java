package com.fedpet.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fedpet.entities.EventLocation;
import com.fedpet.entities.UserType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class EventInputDto {
    //private MultipartFile imageOrVideo;
    private  int id;
    @NotBlank
    private  String name;
    @NotBlank
    private  String description;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String  state;
    @NotBlank
    private String area;
    @NotBlank
    private String Address;
    //get location from map longitude and latitude and generate above details
    private Double longitude;
    private Double latitude;
    @FutureOrPresent
    private LocalDateTime eventDate;
    @NotNull
    @Positive
    private  Integer groupId;
}
