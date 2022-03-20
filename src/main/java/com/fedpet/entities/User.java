package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbluser", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;
    private String username;
    private String lastname;
    private UserType userType;
    private String mobileNumber;
    private String password;
    private String email;
    @OneToOne( mappedBy = "user",cascade = CascadeType.ALL)
    private UserAddress address;
@OneToMany(mappedBy ="user",fetch =  FetchType.LAZY,cascade = CascadeType.ALL)
    private List<UserGroup> userGroupSet;
}
