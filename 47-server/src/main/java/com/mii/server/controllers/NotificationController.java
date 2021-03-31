/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.services.NotificationService;
import com.mii.server.services.ProvinceService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("Notification")
public class NotificationController {
    
    @Autowired
    NotificationService notificationService;
    @Autowired
    ProvinceService provinceService;
    
    @PostMapping("")
    public ResponseEntity<?> sendEmailDemo(Integer employeeId)throws MessagingException{
//        if (employeeId == null){
//            return new ResponseEntity("Please insert employee Id", HttpStatus.NOT_ACCEPTABLE);
//        }
        notificationService.sendMail(employeeId);
        return new ResponseEntity(true, HttpStatus.ACCEPTED);
    }
}
