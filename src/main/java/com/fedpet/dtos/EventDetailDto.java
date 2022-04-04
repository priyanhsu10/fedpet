package com.fedpet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDetailDto {
    private  long id;
    private  String name;
    private  String description;
    private  String imageOrVideo;
    private  String blobName;
    private EventLocationDto eventLocation;
    private LocalDate eventDate;
    private GroupUserDto creatorInfo;
    private GroupInputDto groupInfo;

    private LocalTime eventTime;
    private List<CommentDto> comments;
}
