/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.CobaDTO;
import com.mii.server.dto.ProvDisDTO;
import com.mii.server.dto.RegisterDTO;
import com.mii.server.dto.UserDTO;
import com.mii.server.services.NotificationService;
import com.mii.server.services.UserService;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zahra
 */
@RestController
public class UserManagement {
    
    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;
    
    @GetMapping("/listAllCara2")
    public ResponseEntity<List<UserDTO>> listuser(){
        return new ResponseEntity(userService.getAllUser(), HttpStatus.OK);
    }
    
    @GetMapping("/listAll")
    public List<UserDTO> listbiasa(){
        return userService.getAllUser();
    }
    
    @GetMapping ("/listProvDis")
    public ResponseEntity<List<ProvDisDTO>> getprovis(){
        return new ResponseEntity(userService.getProvDisName(), HttpStatus.OK);
    }
    
    @GetMapping("/listEmployeeToProvince")
    public List<CobaDTO> listcoba(){
        return userService.getAllCoba();
    }
       
    @PostMapping("/insertSaveAll")
    public String insertEmployee (@RequestBody RegisterDTO registerDTO){
//        userService.cobain(registerDTO);
        return userService.register(registerDTO);
    }
    
    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(Integer employeeId) throws MessagingException {
        if(employeeId == null){
            return new ResponseEntity("please insert employee ID", HttpStatus.NOT_ACCEPTABLE);
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity(true, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/registrationMail")
    public String registrationMail (@RequestBody RegisterDTO registerDTO) throws MessagingException{
        userService.register(registerDTO);
        notificationService.sendEmail(registerDTO.getEmployeeId());
        return "EMAIL REGISTRASI BERHASIL DIKIRIMKAN";
    }
}
