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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO-KL
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserManagementService userManagementService;
    
    @Autowired
    private AuthenticationManager  authenticationManager;
    
    
    
//    @Autowired
//    AuthenticationManager authManager;
    
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
    

    public String login(String userName, String userPassword){
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
        Users users = new Users();
        Users userFromdb = userRepository.findByUserName(userName);
        if (userFromdb != null){
            if (!(pass.matches(userPassword, userFromdb.getPassword()))){
                throw new UsernameNotFoundException("kata sandi salah");
            }else{
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userFromdb.getUsername(),
                userFromdb.getPassword(), userFromdb.getAuthorities());
//                Authentication authentication = authenticationManager.authenticate(authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Session Created");
            }
            return userFromdb.getUsername();
        }else{
            throw new UsernameNotFoundException("username tidak ditemukan");
        }
    }
    
    public LoginDTO loginDTO(String userName) {
        Users user = new Users();
        Integer userId = userRepository.findByUserName(userName).getUserId();
        List<Role> roles = userRepository.findByUserName(userName).getRolesList();
        List<String> privilegeNames = new ArrayList<>(); //List<String>authorities = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();

        for (Role r : roles) {
            roleNames.add(r.getRoleName());//authorities.add(r.getRoleName());
            List<Privileges> privileges = roleRepository.findByRoleName(r.getRoleName()).getPrivilegesList();
            for (Privileges p : privileges) {
                privilegeNames.add(p.getPrivilegeName());//authorities.add(p.getPrivilegeName());
            }
        }
        
        LoginDTO regis = new LoginDTO(userName,
                roleNames,
                privilegeNames);
        //LoginDTO regis = new LoginDTO(userName,authorities);
        return regis;
    }
}
