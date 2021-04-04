/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.UserDTO;
import com.mii.server.dtos.UserLoginDTO;
import com.mii.server.dtos.UserSessionDTO;
import com.mii.server.repositories.UserRepository;
import com.mii.server.services.MyUserDetailsService;
import com.mii.server.services.UserLoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
public class HomeResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MyUserDetailsService myUserDetailsServiceImpl;
    
    @Autowired
    UserLoginService userLoginService;

//    @GetMapping("/load")
//    public List<UserDTO> showUserDetails() {
//        return myUserDetailsServiceImpl.loadUserDetailsByUsername("ikhsan");
//    }
    
    @PostMapping("/load")
    public List<UserDTO> showUserDetails(@RequestBody String username) {
        return myUserDetailsServiceImpl.loadUserDetailsByUsername(username);
    }

    @PostMapping("/login")
    public UserSessionDTO login(@RequestBody UserLoginDTO userLoginDTO) throws Exception{
        return userLoginService.login(userLoginDTO);
    }    

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

}
