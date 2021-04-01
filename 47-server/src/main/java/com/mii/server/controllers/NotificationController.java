/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fadel M Nasution
 */
@RestController
@RequestMapping("/email")
public class NotificationController {
    
    @Autowired
    NotificationController notificationController;
    
    @Autowired
    ProvinceController provinceController;
    
    @PostMapping("/sendmail")
    public ResponseEntity<?> sendEmail(Integer employeeId) throws MessagingException{
        if (employeeId == null){
            return new ResponseEntity("please insert employee Id", HttpStatus.ACCEPTED);
        }
        notificationController.sendEmail(employeeId);
        return new ResponseEntity(true, HttpStatus.ACCEPTED);
    }
}
