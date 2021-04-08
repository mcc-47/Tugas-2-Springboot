/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.DataLoginDTO;
import com.mii.server.dtos.LoginDTO;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.services.MyUserDetailsServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class UserManagementController {

    @Autowired
    MyUserDetailsServiceImpl myUserDetailsServiceImpl;
    
    

    @PostMapping("/login")
    public LoginDTO loginDTO(@RequestBody DataLoginDTO dataLoginDTO) {
        return myUserDetailsServiceImpl.loginDTO(myUserDetailsServiceImpl.loadByUserName(dataLoginDTO.getUserName(),dataLoginDTO.getUserPassword()));
    }

}
