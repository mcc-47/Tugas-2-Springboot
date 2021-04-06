/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.services;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.mcc.dto.LoginDTO;
import mii.co.id.mcc.dto.UserSessionDTO;
import mii.co.id.mcc.entities.Roles;
import mii.co.id.mcc.entities.Users;
import mii.co.id.mcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;
    
    AuthenticationManager authenticationManager;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users req = userRepository.findByUserName(userName);
        if (req == null) {
            throw new UsernameNotFoundException("Username Not Found");
        } else {
            return req;
        }
    }
    
    public UserSessionDTO loginUser(LoginDTO loginDTO) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        Users user = userRepository.findByUserName(loginDTO.getUserName());
        if (user == null) {
            throw new UsernameNotFoundException("Username Not Found");
        } else {
            if (enc.matches(loginDTO.getPassword(), user.getPassword())) {
                List<Roles> roleList = user.getRolesList();
                List<String> roleNames = new ArrayList<>();
                for (Roles r : roleList) {
                    roleNames.add(r.getRoleName().toUpperCase());
                }
                UsernamePasswordAuthenticationToken authToken 
                        = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Login Success");
                return new UserSessionDTO(user.getUsername(), roleNames);
            } else {
                throw new UsernameNotFoundException("Login Gagal, Username/Password Salah"); 
            }
        }
    }
    
}
