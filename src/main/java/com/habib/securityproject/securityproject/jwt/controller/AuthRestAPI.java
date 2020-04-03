package com.habib.securityproject.securityproject.controller;

import com.habib.securityproject.securityproject.services.SignUpAndSignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("")
public class AuthRestAPI {

    @Autowired
    private SignUpAndSignInService signUpAndSignInService;



    @GetMapping("/user")
    public String getLoggedAuth() {
        return "Hello";
    }

}