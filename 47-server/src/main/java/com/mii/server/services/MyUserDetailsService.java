/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.UsernameAuthoritiesDto;
import com.mii.server.dto.UsernamePasswordDto;
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
    public Integer loadUserByUsername(String username, String userPassword){
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(username + "Not Found");
        }else{
            if(users.getPassword().equals(userPassword)){
                }
                else{
                        System.out.println("OKE");
                        }
            }
            return users.getUserId();
        }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UsernameAuthoritiesDto login(UsernamePasswordDto upd){
        Collection<Roles> roles = userRepository.findByUsername(upd.getUsername()).getRolesCollection();
        List<String> privilegeName = new ArrayList<>();
        List<String> roleName = new ArrayList<>();
        
        for(Roles r : roles){
            roleName.add(r.getRoleName());
            Collection<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesCollection();
            for (Privileges p : privileges){
                privilegeName.add(p.getPrivilege());
            }
        }
        
        UsernameAuthoritiesDto usernameAuthoritiesDto = new UsernameAuthoritiesDto(
                upd.getUsername(), roleName, privilegeName);
        
        return usernameAuthoritiesDto;
    }

    
}
