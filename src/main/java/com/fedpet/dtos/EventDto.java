package com.fedpet.dtos;

import com.fedpet.entities.EventLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private  long id;
    private  String name;
    private  String description;
    private  byte[] imageOrVideo;
    private  String blobName;
    private EventLocationDto eventLocation;
    private LocalDate eventDate;
    private int creatorId;
    private int groupId;
    private LocalTime eventTime;
    private List<CommentDto> comments;
}
