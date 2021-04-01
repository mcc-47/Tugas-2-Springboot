/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controller;

import com.mii.server.dtos.DataLogDTO;
import com.mii.server.dtos.LoginDTO;
import com.mii.server.entity.Users;
import com.mii.server.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yosie
 */
@RestController
public class LoginController {

    @Autowired
    MyUserDetailService myUserDetailsService;
        
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
 @GetMapping("/login-data")
    public LoginDTO loginDTO() {
//        return myUserDetailsServiceImpl.loadByUserName("ikhsan_1", "ikhsan123");
        return myUserDetailsService.loginDTO(myUserDetailsService.loadByUserName("ikhsan_1", "ikhsan123"));
    }
@PostMapping("/login")
    public LoginDTO loginControl(@RequestBody DataLogDTO dataLogDTO) {
        return myUserDetailsService.loginDTO(myUserDetailsService.loadByUserName(dataLogDTO.getUserName(),
                dataLogDTO.getUserPassword()));
    }
}