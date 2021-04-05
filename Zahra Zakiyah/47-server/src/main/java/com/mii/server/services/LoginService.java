/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.AuthDTO;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private UserManagementService userManagementService;

//    public boolean loadByUserName(String userName){
//        Users user = userRepository.findByUserName(userName);
//        if(user==null){
//            throw new UsernameNotFoundException("username not found");
////            return false;
//        }
//        else{
//            return true;
//        }
//    }
    
    @Override
    public UserDetails loadUserByUsername (String userName){
        Users user = userRepository.findByUserName(userName);
        if(user==null){
            throw new UsernameNotFoundException("USERNAME NOT FOUND");
        }
        else{
            return user;
        }
    }
    
    public String logIn(String userName, String userPassword){
        Users user = userRepository.findByUserName(userName);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        } else{
            if(!user.getPassword().equals(userPassword)){
                return "password salah";
            } else{
                return "Log In Berhasil";
            }
        }
    }
        
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
    
    public String loadByUserName(String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!userDB.getPassword().equals(userPassword)) {
            } else {
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
                                userDB.getPassword(), userDB.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("berhasil ditampilkan");
            }
            return userDB.getUsername();
//            return userDB.getUserId();
        }
    }
    
    public LoginDTO logInFull(String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!userDB.getPassword().equals(userPassword)) {
            }
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userDB.getUsername(),
                                                            userDB.getPassword(), 
                                                            userDB.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
            System.out.println("berhasil ditampilkan");
            
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
//            return userDB.getUserId();
        }
    } 
    
    public AuthDTO logInAuth (String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
        Integer userId = userRepository.findByUserName(userName).getUserId();
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!userDB.getPassword().equals(userPassword)) {
            }
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userDB.getUsername(),
                                                            userDB.getPassword(), 
                                                            userDB.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
            System.out.println("berhasil ditampilkan");
            
            List<Role> roles = userRepository.findByUserName(userName).getRoleList();
            List<String> authorities = new ArrayList<>();

            for (Role r : roles) {
                authorities.add(r.getRoleName());
                List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
                for (Privileges p : privileges) {
                    authorities.add(p.getPrivilegeName());
                }
            }

            AuthDTO login = new AuthDTO(userName,
                    userId,
                    authorities);
            return login;
        }
    } 
    
    public AuthDTO logInAdmin (String userName, String userPassword) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        Users userDB = userRepository.findByUserName(userName);
        Integer userId = userRepository.findByUserName(userName).getUserId();
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!(b.matches(userPassword, userDB.getPassword()))) {
                throw new UsernameNotFoundException("wrong password");
            }
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                                            userDB.getUsername(),
                                                            userDB.getPassword(), 
                                                            userDB.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
//            Authentication auth = authManager.authenticate(authToken);
            System.out.println("berhasil ditampilkan");
            
            List<Role> roles = userRepository.findByUserName(userName).getRoleList();
            List<String> authorities = new ArrayList<>();
            List<String> roleName = new ArrayList<>();
            List<String> denied = new ArrayList<>();
            
                for (Role r : roles) {
                    authorities.add(r.getRoleName());
                    roleName.add(r.getRoleName());
                    List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
                    for (Privileges p : privileges) {
                        authorities.add(p.getPrivilegeName());
                    }
                }
//            if(roleName.contains("admin")){
//                AuthDTO login = new AuthDTO(userName,
//                    userId,
//                    authorities);
//                return login;
//            } else{
//                denied.add("Access Denied");
//                AuthDTO login = new AuthDTO(userName,
//                    userId,
//                    denied);
//                return login;
//            }
            AuthDTO login = new AuthDTO(userName,
            userId,
            authorities);
            return login;
    

        }
    }

}
