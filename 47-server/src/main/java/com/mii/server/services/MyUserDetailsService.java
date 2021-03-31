/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.UsernameAuthoritiesDto;
import com.mii.server.dto.UsernamePasswordDto;
import com.mii.server.entities.Users;
import com.mii.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(username + "Not Found");
        }
        return users;
    }
    
//    public UsernameAuthoritiesDto login(UsernamePasswordDto){
//        if (){
//            
//        }
//    }
    
}
