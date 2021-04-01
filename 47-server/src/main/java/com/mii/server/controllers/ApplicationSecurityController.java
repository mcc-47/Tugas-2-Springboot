package com.mii.server.controllers;

import com.mii.server.dto.LoginDTO;
import com.mii.server.dto.UserSessionDTO;
import com.mii.server.entities.Users;

import com.mii.server.services.ApplicationSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationSecurityController {

    @Autowired
    ApplicationSecurityService applicationSecurityService;

    @GetMapping("/login")
    public LoginDTO loginDTO() {
        return applicationSecurityService.loginDTO(applicationSecurityService.loadByUserName("aul_11", "aul123"));
    }
//    
}
