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
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserManagementService userManagementService;
    private static final Logger logger = Logger.getLogger(MyUserDetailsServiceImpl.class);

    /**
     *
     * @param userName
     * @return
     */
    @Override
    public Users loadUserByUsername(String userName) {

        Users user = userRepository.findByUserName(userName);
        if (user == null) {
            logger.info("----------------------------------------------user name is " + userName);
            throw new UsernameNotFoundException(userName + "Not Found");
        }
        return user;
    }

    public Integer loadByUserName(String userName, String userPassword) {
        Users userDB = userRepository.findByUserName(userName);
        Users user = new Users();
        if (userDB == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            if (!userDB.getPassword().equals(userPassword)) {
            } else {
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(userDB.getUsername(),
                                userDB.getPassword(), user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("panji session");
            }
            return userDB.getUserId();
//            List<Users> temp = new ArrayList<>(userDB.getUserId());
//            return temp;
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

//    public Collection<? extends GrantedAuthority> getAuthorities(Users user) {
////        Integer id = userManagementService.loadByUserName("arnum_13", "arnum123");
//        String[] userRoles = user.getRoleList().stream().map((role) -> role.getRoleName()).toArray(String[]::new);
//        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//        return authorities;
//    }

}
