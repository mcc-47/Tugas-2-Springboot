/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dto.UserLoginDto;
import com.dto.UserSessionDto;
import com.entities.Users;
import com.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired 
    UserRepository userRepository;
    
    @Override
    public Users loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(userName);
        if (user==null) {
            throw new UnsupportedOperationException("Gaada username-nya cuy");
        }
        return user;
    }
    
    public UserSessionDto loginUserByUserPassword(UserLoginDto userLoginDto)throws Exception{
        Users user = loadUserByUsername(userLoginDto.getUserName());
        if (!(user.getPassword().equals(userLoginDto.getUserPassword()))) {
            throw new Exception("Waduu salah password nih ngab");
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userLoginDto.getUserName(), 
                                                            userLoginDto.getUserPassword(), 
                                                            user.getAuthorities());
//        Authentication auth = authManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new UserSessionDto(user.getUsername(), grantedAuth);
    }
}
