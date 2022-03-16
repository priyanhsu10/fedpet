package com.fedpet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResult {
    private int id;
    private String userName;
    private String firstName;
    private String LastName;
    private String JwtToken;
}
