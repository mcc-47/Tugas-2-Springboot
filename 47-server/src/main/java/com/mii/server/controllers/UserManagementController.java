/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.UserManagementDTO;
import com.mii.server.entities.Employees;
import com.mii.server.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/register")
public class UserManagementController {
    @Autowired
    UserManagementService userManagementService;
    
    @PostMapping("/insert")
    public String saveEmp(@RequestBody UserManagementDTO umDTO) {
        return userManagementService.saveEmployee(umDTO);
    }
    
}
