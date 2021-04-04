/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.LoginDTO;
import com.mii.server.dto.UserSessionDTO;
import com.mii.server.entities.Users;
import com.mii.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    
    AuthenticationManager authenticationManager;
    
    @Override
    public UserDetails loadUserByUsername(String userName) {
        Users req = userRepository.findByUserName(userName);
        if(req==null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else{
            return req;
        }
    }
    
    public UserSessionDTO loginUser(LoginDTO loginDTO) {
        Users user = userRepository.findByUserName(loginDTO.getUserName());
        if(user == null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else{
            if(user.getPassword().equals(loginDTO.getPassword())) {
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
//                Authentication auth = authenticationManager.authenticate(authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("login berhasil");
                return new UserSessionDTO(user.getUsername(), user.getAuthorities());
            } else{
                throw new UsernameNotFoundException("login gagal, password salah");
            }
        }
    }
}
