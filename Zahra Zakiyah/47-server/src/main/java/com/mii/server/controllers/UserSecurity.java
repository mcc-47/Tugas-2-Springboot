/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.AuthDTO;
import com.mii.server.dto.DataLoginDTO;
import com.mii.server.dto.LoginDTO;
import com.mii.server.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zahra
 */
@RestController
public class UserSecurity {
    
    @Autowired
    LoginService loginService;
    
//    @GetMapping("/login")
//    public void login(){
//        System.out.println("test");
//    }
    
//    @GetMapping("/username")
//    public boolean findusername(){
//        return loginService.loadByUserName("zaki_10");
//    }

    @GetMapping("/usernamexml")
    public UserDetails findusernamexml(){
        return loginService.loadUserByUsername("zaki_10");
    }
    
//    @PostMapping("/login")
//    public LoginDTO loginDTODTO(@RequestBody DataLoginDTO dataLoginDTO) {
//        return loginService.loginDTO(loginService.loadByUserName(dataLoginDTO.getUserName(), dataLoginDTO.getUserPassword()));
//    }
    
//    @GetMapping("/user")
//    public LoginDTO loginDTO() {
//        return loginService.loginDTO(loginService.loadByUserName("zaki_10","zaki123"));
//    }
    
//    @PostMapping("/login")
//    public LoginDTO loginController(@RequestBody DataLoginDTO dataLoginDTO) {
////        return myUserDetailsServiceImpl.loadByUserName("ikhsan_1", "ikhsan123");
//        return loginService.loginDTO(loginService.loadByUserName(dataLoginDTO.getUserName(),
//                dataLoginDTO.getUserPassword()));
//    }
    
//    @GetMapping("/user")
//    public String logIn(@RequestBody DataLoginDTO dataLoginDTO){
//        return loginService.logIn(dataLoginDTO.getUserName(), dataLoginDTO.getUserPassword());
//    }
    
    @PostMapping("/loginuser")
    public AuthDTO userNameLogin(@RequestBody DataLoginDTO userLoginDto)throws Exception{
        return loginService.loginUserByUserPassword(userLoginDto);
    }
    
    @GetMapping("/trainer")
    public String trainer(){
        return "Trainer session";
    }
    
    @GetMapping("/trainee")
    public String trainee(){
        return "Trainee session";
    }
//    @PreAuthorize("hasRole('admin')")
//    @PostMapping("/loginuser")
//    public String loginfull(@RequestBody DataLoginDTO dataLoginDTO) {
//        return loginService.logInRole(dataLoginDTO.getUserName(),
//                dataLoginDTO.getUserPassword());
//    }
}
