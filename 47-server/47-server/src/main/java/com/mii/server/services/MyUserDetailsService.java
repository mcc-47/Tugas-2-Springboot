/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.UserDTO;
import com.mii.server.entities.User;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.UserRepository;
import com.mii.server.repositories.UserRepositoryHelper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserRepositoryHelper userRepositoryHelper;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private PasswordConfiguration passwordConfiguration;
//    public MyUserDetailsService(UserRepository userRepository) {
//        super();
//        this.userRepository = userRepository;
//    }

//    public User save(UserLoginDTO userLoginDTO) {
//        User user = new User(userLoginDTO.getUsername(), passwordEncoder.encode(userLoginDTO.getPassword()));
//        return userRepository.save(user);
//    }
//    @Override
    public List<UserDTO> loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserDetailsByUsername");
        List<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        } else {
            List<UserDTO> dto = new ArrayList<>();
            for (User u : userRepository.findByUsername(username)) {
                UserDTO t = new UserDTO(u.getId(), u.getUsername(), u.getRoles());
                dto.add(t);
            }
            return dto;
        }
    }
    
    /*
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        // throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
     */

    public User loadUsername(String username) throws UsernameNotFoundException {
        System.out.println("ini loadUsername 1");
        User user = userRepositoryHelper.findByUsername(username);
         if (user ==null) {
            throw new UnsupportedOperationException("Username tidak ditemukan");
        }
        return user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        System.out.println("ini loadUserByUsername");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
