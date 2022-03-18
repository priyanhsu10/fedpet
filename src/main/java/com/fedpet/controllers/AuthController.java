package com.fedpet.controllers;

import com.fedpet.Interfaces.IUserAuthenticationService;
import com.fedpet.dtos.AuthInputDto;
import com.fedpet.dtos.AuthenticationResult;
import com.fedpet.dtos.UserRegistrationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class AuthController {

    private IUserAuthenticationService userAuthenticationService;

    public AuthController(IUserAuthenticationService iUserAuthenticationService) {
        this.userAuthenticationService = iUserAuthenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid  @RequestBody UserRegistrationDto userRegistrationDto) {

        userAuthenticationService.register(userRegistrationDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResult> authenticate(@Valid  @RequestBody AuthInputDto authInputDto) {

        AuthenticationResult result = userAuthenticationService.authenticate(authInputDto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/ping")
    public  String getTime(){
        return LocalDateTime.now().toString();
    }
}
