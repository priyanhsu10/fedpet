package com.fedpet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInputDto {
    private long id;
    private String commentData;
    private int commenterId;
    private int eventId;
}
