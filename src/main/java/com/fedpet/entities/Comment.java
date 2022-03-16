package com.fedpet.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblcomment", schema = "public")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String commentData;
    @ManyToOne
    private User commenter;
    @ManyToOne
    private Event event;
    private LocalDateTime commentAt;
}
