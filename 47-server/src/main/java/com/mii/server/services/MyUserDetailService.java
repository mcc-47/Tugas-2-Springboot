/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.DataLoginDTO;
import com.mii.server.dto.LoginDTO;
import com.mii.server.entities.Privileges;
import com.mii.server.entities.Role;
import com.mii.server.entities.Users;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class MyUserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserManagementService userManagementService;
   

    @Override
    public Users loadUserByUsername(String userName) {
        Users users = userRepository.findByUserName(userName);
        if (users == null) {
            throw new UsernameNotFoundException(userName + "Not Found");
        }
        return users;
    }

    public String loadByUserName(String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
//            return false;
        } else {
            if (userDB.getPassword().equals(userPassword)){
                System.out.println("SESSION BERHASIL");
            }else{
                System.out.println("SESSION GAGAL");
            }
        }
        return userDB.getUsername();
    }
    
//    public LoginDTO loginDTO (String userName){
//        Integer userId = userRepository.findbyUserName(userName).getUserId();
//        List<Role> roles = userRepository.findbyUserName(userName).getRolesList();
//        List<String> privilegeNames = new ArrayList<>();
//        List<String> roleNames = new ArrayList<>();
//        
//        for (Role r : roles){
//            roleNames.add(r.getRoleName());
//            List<Privileges> privilegeses = r.getPrivilegesList();
//            for (Privileges p : privilegeses){
//                privilegeNames.add(p.getPrivilegeName());
//            }
//        }
//        
//        LoginDTO nreg = new LoginDTO(userName, roleNames, privilegeNames);
//        
//        return nreg;
//    }
    
    public LoginDTO loginDTO(DataLoginDTO dataLoginDTO) {
        Users user = userRepository.findByUserName(dataLoginDTO.getUserName());
        if(user == null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else{
            if(user.getPassword().equals(dataLoginDTO.getPassword())) {
                System.out.println("login berhasil");
                List<Role> userRoles = user.getRolesList();
                List<String> roleList = new ArrayList<>();
                List<String> privilegeList = new ArrayList<>();
                for(Role r : userRoles) {
                    roleList.add(r.getRoleName());
                    List<Privileges> userPrivileges = r.getPrivilegesList();
                    for(Privileges p : userPrivileges) {
                        privilegeList.add(p.getPrivilegeName());
                    }
                }
                return new LoginDTO(user.getUsername(), roleList, privilegeList);
//                UsernamePasswordAuthenticationToken authToken
//                        = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else{
                System.out.println("login gagal, password salah");
                return new LoginDTO(user.getUsername(), null, null);
            }
        }
    }
    
    public String login (String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
//        Users user = new Users();
        if (userDB != null) {//ada
            if (!(userDB.getPassword().equals(userPassword))) {
                throw new UsernameNotFoundException("password wrong");
            } else {
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
                                userDB.getPassword(), userDB.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Login with Session");
            }
            return userDB.getUsername();
//            return userDB.getUserId();
           
        } else {
             throw new UsernameNotFoundException("username not found");
        }
    }
}
