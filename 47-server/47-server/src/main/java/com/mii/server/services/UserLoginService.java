/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.UserLoginDTO;
import com.mii.server.dtos.UserSessionDTO;
import com.mii.server.entities.User;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class UserLoginService {
    
    @Autowired
    MyUserDetailsService myUserDetailsServiceImpl;
    
    @Autowired
    private UserRepository userRepository;
    
    public UserSessionDTO login(UserLoginDTO userLoginDTO) throws Exception{
        BCryptPasswordEncoder b = new BCryptPasswordEncoder(10);
        User user = myUserDetailsServiceImpl.loadUsername(userLoginDTO.getUsername());
//        System.out.println(user.getPassword());
//        System.out.println(userLoginDTO.getPassword());
        if(!(b.matches(userLoginDTO.getPassword(), user.getPassword()))){
            throw new Exception("Invalid Password");
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userLoginDTO.getUsername(), 
                                                            userLoginDTO.getPassword(), 
                                                            user.getAuthorities());
        //        Authentication auth = authManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
//        return user;
        return new UserSessionDTO(user.getUsername(), grantedAuth);
    }
    
    /*
        User user = myUserDetailsServiceImpl.loadUsername(userLoginDTO.getUsername());
        if(!(user.getPassword().equals(userLoginDTO.getPassword()))){
            throw new Exception("Invalid Password");
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userLoginDTO.getUsername(), 
                                                            userLoginDTO.getPassword(), 
                                                            user.getAuthorities());
        //        Authentication auth = authManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
//        return user;
        return new UserSessionDTO(user.getUsername(), grantedAuth);
    }
    */
}
