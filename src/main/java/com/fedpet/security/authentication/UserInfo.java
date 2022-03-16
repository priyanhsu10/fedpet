package com.fedpet.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private  int id;
    private  String firstName;
    private String lastName;
    private  String userName;
}
