/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dto.UserLoginDto;
import com.dto.UserSessionDto;
import com.services.NotificationService;
import com.services.UserService;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @PostMapping("/user-token")
    public UserSessionDto userNameLogin(@RequestBody UserLoginDto userLoginDto)throws Exception{
        return userService.loginUserByUserPassword(userLoginDto);
    }
    
//    @GetMapping("/logout")
//    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response){
//        
//        HttpSession session = request.getSession(false);
//        SecurityContextHolder.clearContext();
//
//          session = request.getSession(false);
//          if(session != null) {
//              session.invalidate();
//          }
//
//          for(Cookie cookie : request.getCookies()) {
//              cookie.setMaxAge(0);
//          }
//
//          return "redirect:/login?logout";
//    }
}
