package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tblevent",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String name;
    private  String description;
    @Lob
    @Column(name = "image_or_video", columnDefinition="BLOB")
    private  byte[] imageOrVideo;
    private  String blobName;
    private  EventLocation eventLocation;
    private LocalDate eventDate;
    private LocalTime eventTime;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;

}
