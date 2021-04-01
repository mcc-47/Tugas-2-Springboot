/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.LoginDTO;
import com.mii.server.dto.RegisterDTO;
import com.mii.server.dto.UserSessionDTO;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Users;
import com.mii.server.services.NotificationService;
import com.mii.server.services.RegisterService;
import com.mii.server.services.UserService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
//@RequestMapping("user")
public class UserManagement {
    @Autowired
    RegisterService registerService;   
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    UserService userService;
    
    @GetMapping("login")
    public UserSessionDTO testLogin() {
//        System.out.println("test permit all");
//        userService.loginUser("ikhsan_1", "ikhsan12");
        LoginDTO req = new LoginDTO("ikhsan_1", "ikhsan123");
        return userService.loginUser(req);
//        return "berhasil";
//        return userService.loginUser(req);
    }
    
    @PostMapping("login")
    public UserSessionDTO testLogin(@RequestBody LoginDTO req) {
        return userService.loginUser(req);
    }
    
    @GetMapping("get-user")
    public ResponseEntity<?> getUser() {
        return new ResponseEntity(userService.loadUserByUsername("ikhsan_1"), HttpStatus.OK);
    }
    
    
    //JSON Request body format
//    {
//    "prefix": "MCC",
//    "idEmployee": 30,
//    "nameEmployee": "vela",
//    "birthdate": "1998-01-01",
//    "gender": "Perempuan",
//    "email": "velaflorentina@gmail.com",
//    "villageId": 5,
//    "phone": "1234567890",
//    "linkedin": "florentinavela",
//    "majorId": 13,
//    "universityId": 5
//    }
    
    //create user (register and send email)
    @PostMapping("register")
    public ResponseEntity<String> insertOne(@RequestBody RegisterDTO registerDTO) throws MessagingException {
        Employees newEmployee = registerService.insertOne(registerDTO);
        notificationService.sendEmail(newEmployee.getEmployeeId());
        return new ResponseEntity<>(String.format("Selamat Anda berhasil registrasi dengan ID %d.\nMohon cek email Anda!", newEmployee.getEmployeeId()), HttpStatus.OK);
    }
    
    //get user
    @GetMapping("{id}")
    public ResponseEntity<RegisterDTO> getOne(@PathVariable Integer id) throws MessagingException {
        return new ResponseEntity<>(registerService.getOne(id),HttpStatus.OK);
    }
    
    //send email to the given id
    @PostMapping("send-notif/{id}")
    public ResponseEntity<?> sendNotif(@PathVariable Integer id) throws MessagingException {
        if (id == null) {
            return new ResponseEntity<>("Email notifikasi gagal dikirim. Masukkan id!", HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            notificationService.sendEmail(id);
            return new ResponseEntity<>("Email notifikasi telah berhasil dikirim!", HttpStatus.ACCEPTED);
        }
    }
}
