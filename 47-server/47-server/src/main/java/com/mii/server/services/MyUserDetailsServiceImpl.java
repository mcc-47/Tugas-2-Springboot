/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.LoginDTO;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import com.sun.istack.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserManagementService userManagementService;
    
    @Autowired
    AuthenticationManager authenticationManager;

    /**
     *
     * @param userName
     * @return
     */
    @Override
    public Users loadUserByUsername(String userName) {

        Users user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName + "Not Found");
        }
        return user;
    }

//    public String loadByUserName(String userName, String userPassword) {
//        Users userDB = userRepository.findByUserName(userName);
//        Users user = new Users();
//        if (userDB == null) {
//            throw new UsernameNotFoundException("username not found");
//        } else {
//            if (!userDB.getPassword().equals(userPassword)) {
//            } else {
//                UsernamePasswordAuthenticationToken authToken
//                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
//                                userDB.getPassword(), userDB.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//                System.out.println("Login with Session");
//            }
//            return userDB.getUsername();
////            return userDB.getUserId();
//        }
//    }
    
    public String loadByUserName(String userName, String userPassword) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        Users userDB = userRepository.findByUserName(userName);
//        Users user = new Users();
        if (userDB != null) {//jika username ada
            if (!(b.matches(userPassword,userDB.getPassword()))) {//valueinput=dbencryp
                throw new UsernameNotFoundException("password wrong");
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
            throw new UsernameNotFoundException("username not found");
        }
    }

    public LoginDTO loginDTO(String userName) {
        Users user = new Users();
        Integer userId = userRepository.findByUserName(userName).getUserId();
        List<Role> roles = userRepository.findByUserName(userName).getRoleList();
        List<String> authorities = new ArrayList<>();
  

        for (Role r : roles) {
            authorities.add("ROLE_"+r.getRoleName().toUpperCase());
            List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
            for (Privileges p : privileges) {
                authorities.add(p.getPrivilegeName());
            }
        }

        LoginDTO nreg = new LoginDTO(userName,authorities);
        return nreg;
    }

    private Object hashCode(String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
