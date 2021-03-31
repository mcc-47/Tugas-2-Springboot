/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.entities.Users;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return user;
    }
    
}
