package com.fedpet.dtos;

import com.fedpet.entities.Event;
import com.fedpet.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private long id;
    private String commentData;
    private int commenterId;
    private int eventId;
    private LocalDateTime commentAt;
}
