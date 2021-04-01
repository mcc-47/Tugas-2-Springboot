/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dto.UserLoginDto;
import com.dto.UserSessionDto;
import com.entities.Users;
import com.services.NotificationService;
import com.services.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jakab
 */
@RestController
@RequestMapping("/api/management")
public class UserManagementController {
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    UserService userService;
    
    @PostMapping("/email-sender")
    public ResponseEntity<?> sendEmailConfirm (Integer employeeId) throws MessagingException{
        if (employeeId==null) {
            return new ResponseEntity<>("insert employee id first", HttpStatus.NOT_ACCEPTABLE);
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/user")
    public UserSessionDto userName(@RequestBody UserLoginDto userLoginDto){
        Users user = userService.loadUserByUsername(userLoginDto.getUserName());
        System.out.println("cociks username ada ngab");
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new UserSessionDto(user.getUsername(), grantedAuth);
    }
    
    @PostMapping("/user-token")
    public UserSessionDto userNameLogin(@RequestBody UserLoginDto userLoginDto)throws Exception{
        Users user = userService.loadUserByUsername(userLoginDto.getUserName());
        if (!(user.getPassword().equals(userLoginDto.getUserPassword()))) {
            throw new Exception("Wrong Password");
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userLoginDto.getUserName(), 
                                                            userLoginDto.getUserPassword(), 
                                                            user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        System.out.println("Success Vruh Huha Huba");
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new UserSessionDto(user.getUsername(), grantedAuth);
    }
    
    @PostMapping("/user-login")
    public UserSessionDto userName(){
        Users user = userService.loadUserByUsername("ikhsan_1");
        System.out.println("Oke user diambil ada");
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new UserSessionDto(user.getUsername(), grantedAuth);
    }
    
    
    //Mapping admin-dashboard hanya bisa di akses oleh Role Admin
    @GetMapping("admin-dashboard")
    public String getUsers(HttpServletRequest request) throws Exception {
        if (request.isUserInRole("admin")) {
            return "Access Granted"; 
        } else {
            throw new Exception("Error mas");
        }
        
    }
}
