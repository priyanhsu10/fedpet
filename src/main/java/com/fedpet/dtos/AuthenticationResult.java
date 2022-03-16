package com.fedpet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResult {
 private  SuccessResult successResult;
 private  boolean IsSuccessAuthentication;
 private  String Error;

}
