/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dto.UserLoginDto;
import com.dto.UserSessionDto;
import com.entities.Role;
import com.entities.Users;
import com.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired 
    UserRepository userRepository;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
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
        if (!(passwordEncoder.matches(userLoginDto.getUserPassword(), user.getPassword()))) {
            throw new Exception("Waduu salah password nih ngab");
        }
        //untuk setting session dan atau cookies
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userLoginDto.getUserName(),        //principal, credential, atoritas yg disimpen pada sesi tsb
                                                            userLoginDto.getUserPassword(), 
                                                            user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken); //beneran set session
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()) { //loop utk get otoritas dalam list<String>
            grantedAuth.add(auth.getAuthority());
        }
        return new UserSessionDto(user.getUsername(), grantedAuth);
    }
    
    
    
    public Users insert(Users user){
        user.setUserPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleCollection(Arrays.asList(new Role(3)));
        return userRepository.save(user);
    }
}
