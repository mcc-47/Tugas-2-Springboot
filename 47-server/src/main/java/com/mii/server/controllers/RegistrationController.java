/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.RegistrationDTO;
import com.mii.server.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fadel M Nasution
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired
    RegistrationService registrationService;
    
    @PostMapping
    public String insert(@RequestBody RegistrationDTO registrationDTO) {
        registrationService.insertEmployee(registrationDTO);
        return "Data Inserted";
    }
}
