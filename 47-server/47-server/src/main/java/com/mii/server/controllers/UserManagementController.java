/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.DataLoginDTO;
import com.mii.server.dtos.LoginDTO;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.services.MyUserDetailsServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
public class UserManagementController {

    @Autowired
    MyUserDetailsServiceImpl myUserDetailsServiceImpl;

    @PostMapping("/login")
    public LoginDTO loginController(@RequestBody DataLoginDTO dataLoginDTO) {
//        return myUserDetailsServiceImpl.loadByUserName("ikhsan_1", "ikhsan123");
        return myUserDetailsServiceImpl.loginDTO(myUserDetailsServiceImpl.loadByUserName(dataLoginDTO.getUserName(),
                dataLoginDTO.getUserPassword()));
    }

//    UserManagementService userManagementService;
//    @PostMapping("/login")
//    public Users username() {
//        return myUserDetailsService.loadUserByUsername("ikhsan_1");
//    }
//    @GetMapping("/login")
//    public Users username(@RequestBody Users users) {
//        return userManagementService.login(users);
//    }
//    @GetMapping("/user")
//    public void usernames() {
//        String a = myUserDetailsServiceImpl.loadByUserName("arnum_13", "arnum123").toString();
//        
//        System.out.println(a);
//    }
    /*
    @Autowired
    AuthenticationManager authenticationManager;
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody Users user) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
     */
}
