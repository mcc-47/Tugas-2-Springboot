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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
//                UsernamePasswordAuthenticationToken authToken
//                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
//                                userDB.getPassword(), user.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("berhasil ditampilkan");
            }
            return userDB.getUsername();
//            return userDB.getUserId();
        }
    }
    
    
//    UserDetails loadUserByUserName (String userName) throws UsernameNotFoundException{
//        
//    }

}
