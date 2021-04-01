/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.service;

import com.mii.server.dtos.LoginDTO;
import com.mii.server.entity.Privileges;
import com.mii.server.entity.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author MyLaptop
 */
@Service
public class MyUserDetailService implements UserDetailsService {
   @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserManagementService userManagementService;
    
    /**
     *
     * @param userName
     * @return
     */
    
    @Override
    public Users loadUserByUsername(String userName) {
        Users users = userRepository.findByUserName(userName);
        if (users == null) {
            throw new UsernameNotFoundException(userName + "Not Found");
        }
        return users;
    }

    public String loadByUserName(String userName, String userPassword) {
        Users userdb = userRepository.findByUserName(userName);
        Users user = new Users();
        if (userdb == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!userdb.getPassword().equals(userPassword)) {
            } else {
//                UsernamePasswordAuthenticationToken authToken
//                        = new UsernamePasswordAuthenticationToken(userdb.getUsername(),
//                                userdb.getPassword(), user.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("session");
            }
            return userdb.getUsername();
        }
    }
public LoginDTO loginDTO(String userName) {
        Users user = new Users();
        Integer userId = userRepository.findByUserName(userName).getUserId();
        List<Role> roles = userRepository.findByUserName(userName).getRoleList();
        List<String> privilegeNames = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();

//        for (Role r : roles) {
//            roleNames.add(r.getRoleName());
//            List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
//            for (Privileges p : privileges) {
//                privilegeNames.add(p.getPrivilegeName());
//            }
//        }
//        
        LoginDTO nreg = new LoginDTO(userName,
                roleNames,
                privilegeNames);
        return nreg;
    }
}