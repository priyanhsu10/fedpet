package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tblgroup",schema = "public")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private  int groupOwnerId;
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> members;
    private  double totalContribution;
    private GroupLocation GroupLocation;


}
