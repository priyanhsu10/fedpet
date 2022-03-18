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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User commenter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;
    private LocalDateTime commentAt;
}
