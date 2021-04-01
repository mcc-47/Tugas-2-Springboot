/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.LoginDTO;
import com.mii.server.dto.UserSessionDTO;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Roles;
import com.mii.server.entities.Users;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
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
 * @author ACER
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) {
        Users req = userRepository.findByUserName(userName);
//        Users user = new Users();
        if(req==null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else{
//            UsernamePasswordAuthenticationToken authToken
//                    = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword(), user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authToken);
            return req;
        }
    }
    
    public UserSessionDTO loginUser(LoginDTO loginDTO) {
        Users user = userRepository.findByUserName(loginDTO.getUserName());
        if(user == null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else{
            if(user.getPassword().equals(loginDTO.getPassword())) {
                System.out.println("login berhasil");
                List<Roles> userRoles = user.getRolesList();
                List<String> roleList = new ArrayList<>();
                List<String> privilegeList = new ArrayList<>();
                for(Roles r : userRoles) {
                    roleList.add(r.getRoleName());
                    List<Privileges> userPrivileges = r.getPrivilegesList();
                    for(Privileges p : userPrivileges) {
                        privilegeList.add(p.getPrivilegeName());
                    }
                }
                return new UserSessionDTO(user.getUsername(), roleList, privilegeList);
//                UsernamePasswordAuthenticationToken authToken
//                        = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else{
                System.out.println("login gagal, password salah");
                return new UserSessionDTO(user.getUsername(), null, null);
            }
        }
    }
    
    
    
}
