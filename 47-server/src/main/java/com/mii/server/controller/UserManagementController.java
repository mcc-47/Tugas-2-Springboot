/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controller;

import com.mii.server.service.NotificationService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/email-demo")
public class UserManagementController {
    
    @Autowired
    NotificationService notificationService;
    
    @PostMapping()
    public ResponseEntity<?> sendEmailDemo (Integer employeeId) throws MessagingException{
        if (employeeId == null){
            return new ResponseEntity("Please insert employee ID", HttpStatus.NOT_ACCEPTABLE);
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity(true, HttpStatus.ACCEPTED);

    }
}