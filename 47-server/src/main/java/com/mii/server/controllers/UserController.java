/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.DataLoginDTO;
import com.mii.server.dto.LoginDTO;
import com.mii.server.entities.Users;

import com.mii.server.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/management")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public LoginDTO userName(@RequestBody LoginDTO loginDTO) {
        Users user = userService.loadUserByUsername(loginDTO.getUserName());
        System.out.println("Username ada di db");
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new LoginDTO(user.getUsername(), grantedAuth);
    }

    @PostMapping("/user-token")
    public LoginDTO userNameLogin(@RequestBody DataLoginDTO dataLoginDTO) throws Exception {
        Users user = userService.loadUserByUsername(dataLoginDTO.getUserName());
        if (!(user.getPassword().equals(dataLoginDTO.getUserPassword()))) {
            throw new Exception("Wrong Password");
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                dataLoginDTO.getUserName(),
                dataLoginDTO.getUserPassword(),
                user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        System.out.println("Success Vruh Huha Huba");
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new LoginDTO(user.getUsername(), grantedAuth);
    }

    @PostMapping("/user-login")
    public LoginDTO userName() {
        Users user = userService.loadUserByUsername("ikhsan_1");
        System.out.println("Oke user diambil ada");
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new LoginDTO(user.getUsername(), grantedAuth);
    }
}
