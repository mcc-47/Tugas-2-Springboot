/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.DataLoginDTO;
import com.mii.server.dtos.LoginDTO;

import com.mii.server.entities.Privileges;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;

import java.util.ArrayList;

import java.util.List;
import javafx.scene.chart.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messages;

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
    public Users loadUserByUsername(String userName) throws UsernameNotFoundException {

        Users user = userRepository.findByUserName(userName);

        return user;
    }

    public DataLoginDTO loadByUserNamePassword(String userName, String userPassword) {
        Users userDB = userRepository.findByUserNamePassword(userName, userPassword);
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username is Not Found!!!!");
        } else if (!(userDB.getPassword().equals(userPassword))) {
            throw new UsernameNotFoundException("Password is Wrong!!!");
        } else {
            UsernamePasswordAuthenticationToken authToken
                    = new UsernamePasswordAuthenticationToken(
                            userDB.getUsername(),
                            userDB.getPassword(), 
                            user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
            
        }
        List<String> grantedAuth = new ArrayList<>();
        for (GrantedAuthority auth : user.getAuthorities()){
            grantedAuth.add(auth.getAuthority());
        }
        return new DataLoginDTO(user.getUsername(), grantedAuth);
    }


//public String loadByUserName(String userName) {
//        Users userDB = userRepository.findByUserName(userName);
//        Users user = new Users();
//        if (userDB == null) {
//            throw new UsernameNotFoundException("username not found");
//        } else {
//            if (!userDB.getUsername().equals(userName)) {
//            } else {
//                UsernamePasswordAuthenticationToken authToken
//                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
//                                userDB.getPassword(), user.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//                System.out.println("panji session");
//            }
//            return userDB.getUsername();
//        }
//    }


    public LoginDTO loginDTO(String userName) {
        Users user = new Users();
        Integer userId = userRepository.findByUserName(userName).getUserId();
        List<Role> roles = userRepository.findByUserName(userName).getRoleList();
        List<String> privilegeNames = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();

        for (Role r : roles) {
            roleNames.add(r.getRoleName());
            List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
            for (Privileges p : privileges) {
                privilegeNames.add(p.getPrivilegeName());
            }
        }

        LoginDTO nreg = new LoginDTO(userName,
                roleNames,
                privilegeNames);
        return nreg;
    }

//    public String loadByUserNamePassword(String userName, String userPassword) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
