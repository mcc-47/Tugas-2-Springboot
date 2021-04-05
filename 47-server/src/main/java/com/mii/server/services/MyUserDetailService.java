/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.LoginDTO;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fadel M Nasution
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserManagementService userManagementService;
    
    @Override
    public Users loadUserByUsername(String userName) {

        Users user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName + "Not Found");
        }
        return user;
    }

    public String loginByUserName(String userName, String userPassword) {
//        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Users userDB = userRepository.findByUserName(userName);
//        Users user = new Users();
        if (userDB != null) { //If username found in database
              if (userPassword == null ? userDB.getPassword() != null : !userPassword.equals(userDB.getPassword())){
//            if (!(bcrypt.matches(userPassword, userDB.getPassword()))) { ////valueinput=dbencryp
                throw new UsernameNotFoundException("Password is not correct!");
            } else {
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
                                userDB.getPassword(), userDB.getAuthorities());
//                Authentication auth = authenticationManager.authenticate(authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Login with Session");
            }
            return userDB.getUsername();
//            return userDB.getUserId();

        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    public LoginDTO loginDTO(String userName) {
        Users user = new Users();
        Integer userId = userRepository.findByUserName(userName).getUserId();
        List<Role> roles = userRepository.findByUserName(userName).getRoleList();
        List<String> authorities = new ArrayList<>();

        for (Role r : roles) {
            authorities.add(r.getRoleName());
            List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
            for (Privileges p : privileges) {
                authorities.add(p.getPrivilegeName());
            }
        }

        LoginDTO nreg = new LoginDTO(userName,
                authorities);
        return nreg;
    }
    
    private Object hashCode(String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
