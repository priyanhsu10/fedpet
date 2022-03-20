package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tblgroup",schema = "public")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private  String groupName;

    @OneToMany(mappedBy ="group",fetch =  FetchType.LAZY,cascade = CascadeType.ALL)
    private List<UserGroup> members= new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private  double totalContribution;
    private  boolean isActive;
    private UserType primaryUserType;
    private GroupLocation GroupLocation;
    private LocalDateTime addedAt;
    @OneToMany(mappedBy = "group",fetch = FetchType.LAZY)
   private  List<Event> events= new ArrayList<>();
    public  void addMember(UserGroup userGroup){
        members.add(userGroup);
    }


}
