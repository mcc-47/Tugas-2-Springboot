/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;
import com.mii.server.dto.DataLoginDTO;
import com.mii.server.dto.LoginDTO;
import com.mii.server.services.MyUserDetailService;
import com.mii.server.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fadel M Nasution
 */
@RestController
public class UserManagementController {
    
//    @Autowired
//    UserManagementService userManagementService;
    
    @Autowired
    MyUserDetailService myUserDetailService;
    
    @PostMapping("/login")
    public LoginDTO loginDTO(@RequestBody DataLoginDTO dataLoginDTO) {
        return myUserDetailService.loginDTO(myUserDetailService.loadByUserName(dataLoginDTO.getUserName(), dataLoginDTO.getUserPassword()));
    }
    
}
