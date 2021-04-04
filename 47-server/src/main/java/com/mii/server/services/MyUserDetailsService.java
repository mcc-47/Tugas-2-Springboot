/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.AuthenticationResponse;
import com.mii.server.dto.LoginDto;
import com.mii.server.entities.Users;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;
    
//    @Autowired
//    RoleRepository roleRepository;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(username + "Not Found");
        }
        return users;
    }
    
    public AuthenticationResponse login(LoginDto loginDto)throws Exception{
        Users users = userRepository.findByUsername(loginDto.getUsername());
        BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
        if (users == null || !(passEncoder.matches(loginDto.getPassword(), users.getPassword()))){
            throw new Exception("Wrong Username or Password.");
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), 
                loginDto.getPassword(), 
                users.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : users.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new AuthenticationResponse(users.getUsername(), grantedAuth);
        
    }
}
