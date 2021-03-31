/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Users;
import com.mii.server.repositories.UserRepository;
import org.hibernate.dialect.MySQLStorageEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class UserManagementService extends MyUserDetailsServiceImpl {

    @Autowired
    private UserRepository userRepository;
    private MyUserDetailsServiceImpl myUserDetailsServiceImpl;

//    public Integer login(Users u) {
//        Users user = new Users();
//        if(myUserDetailsServiceImpl.loadByUserName()){
//            
//    }

}
