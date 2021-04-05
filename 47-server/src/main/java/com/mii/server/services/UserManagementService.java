/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;


import com.mii.server.dto.UserManagementDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Role;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Users;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class UserManagementService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserManagementService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    //Read
    public List<Employees>getAllemp(){
        employeeRepository.findAll();
        List<Employees> dataemp = new ArrayList<>();
        for (Employees s : employeeRepository.findAll()){
            UserManagementDTO userManagementDTO = new UserManagementDTO(
            s.getEmployeeId(),
            s.getEmployeeName(),
            s.getAddresses(),
            s.getBirthDate(),
            s.getGender(),
            s.getEmail()
            );
        }
        return dataemp;
    }
    
}
    
