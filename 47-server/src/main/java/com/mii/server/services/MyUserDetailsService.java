/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.AuthenticationResponse;
import com.mii.server.dto.LoginDto;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Roles;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    @Autowired
    RoleRepository roleRepository;
    
//    @Override
    public Users loadUserByUsername(String username, String userPassword){
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(username + "Not Found");
        }
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(username + "Not Found");
        }
        return users;
    }
    
    public AuthenticationResponse login(LoginDto upd)throws Exception{
        Users users = userRepository.findByUsername(upd.getUsername());
        if (users == null || !(upd.getPassword().equals(users.getPassword()))){
            throw new Exception("Wrong Username or Password.");
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                upd.getUsername(), 
                upd.getPassword(), 
                users.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : users.getAuthorities()) {
            grantedAuth.add(auth.getAuthority());
        }
        return new AuthenticationResponse(users.getUsername(), grantedAuth);
        
//        for(Roles r : roles){
//            roleName.add(r.getRoleName());
//            Collection<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesCollection();
//            for (Privileges p : privileges){
//                privilegeName.add(p.getPrivilege());
//            }
//        }
    }
}
