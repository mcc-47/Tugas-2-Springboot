/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.DataLogDTO;
import com.mii.server.dto.LoginDTO;
import com.mii.server.entities.Users;
import com.mii.server.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO-KL
 */
@RestController
public class UserController {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    
    
    @GetMapping("/cobalogin")
    public void testLogin() {
        System.out.println("test permitAll");
    }
    
    @GetMapping("/user")
    public Users username(){
        System.out.println("coba");
        return myUserDetailsService.loadUserByUsername("arnum_13");
    }
//    @GetMapping("/testuser")
//    public boolean usertest(){
//        System.out.println("tes");
//        return myUserDetailsService.loadByUserName("ikhsan_1");
//
//    }
 @GetMapping("/login-web")
    public LoginDTO loginDTO() {
//        return myUserDetailsServiceImpl.loadByUserName("ikhsan_1", "ikhsan123");
        return myUserDetailsService.loginDTO(myUserDetailsService.login("ikhsan_1", "ikhsan123"));
    }
@PostMapping("/login")
    public LoginDTO loginControl(@RequestBody DataLogDTO dataLogDTO) {
        return myUserDetailsService.loginDTO(myUserDetailsService.login(dataLogDTO.getUserName(),
                dataLogDTO.getUserPassword()));
    }
}
