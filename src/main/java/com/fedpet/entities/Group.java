package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Set<UserGroup> members;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private  double totalContribution;

    private GroupLocation GroupLocation;


}
