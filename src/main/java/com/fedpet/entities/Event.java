package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @NotBlank
    private  String name;
    @NotBlank
    private  String description;
    private  String imageOrVideo;
    private  String blobName;
    @NotNull
    private  EventLocation eventLocation;
    @NotNull
    private LocalDate eventDate;
    @NotNull
    private LocalTime eventTime;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "event")
    private List<Comment> comments;
    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "creatorId")
    private  User creator;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId", referencedColumnName = "id")
        private  Group group;




}
