/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.AuthDTO;
import com.mii.server.dto.DataLoginDTO;
import com.mii.server.dto.LoginDTO;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zahra
 */
    
    @Service
public class LoginService implements UserDetailsService{

    @Autowired 
    UserRepository userRepository;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public Users loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(userName);
        if (user==null) {
            throw new UnsupportedOperationException("User Name NOT FOUND");
        }
        return user;
    }
    
    public AuthDTO loginUserByUserPassword(DataLoginDTO userLoginDto)throws Exception{
        Users user = loadUserByUsername(userLoginDto.getUserName());
        if (!(passwordEncoder.matches(userLoginDto.getUserPassword(), user.getPassword()))) {
            throw new Exception("Wrong Pasword");
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
        return new AuthDTO(user.getUsername(),user.getUserId(), grantedAuth);
    }
    
    
    
    public Users insert(Users user){
        user.setUserPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleCollection(Arrays.asList(new Role(3)));
        return userRepository.save(user);
    }
}
