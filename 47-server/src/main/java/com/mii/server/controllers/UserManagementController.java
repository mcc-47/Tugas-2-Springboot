/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.DataLoginDTO;
import com.mii.server.dto.LoginDTO;
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
import com.mii.server.services.MyUserDetailService;
import com.mii.server.services.NotificationService;
import com.mii.server.services.UserManagementService;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
//@RequestMapping("/api/email-demo") --> semua mapping yang ada di bawahnya menggunakan request mapping yang ada di kurungnya
public class UserManagementController {
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    UserManagementService userManagementService; 
    
    @Autowired
    MyUserDetailService myUserDetailService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserManagementController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @GetMapping("/getall")
    public List<Employees > employee(){
        return userManagementService.getAllemp();
    }
    
    @PostMapping()
    public ResponseEntity<?> sendEmailDemo (Integer employeeId) throws MessagingException{
        if (employeeId == null){
            return new ResponseEntity("Please insert employee ID", HttpStatus.NOT_ACCEPTABLE);
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity(true, HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public Employees saveEmployee(UserManagementDTO userManagementDTO){
        List<Role> role =   new ArrayList<>();
        role.add(new Role(2, "trainer"));
        Employees employee = new Employees(
            userManagementDTO.getPrefix(),
            userManagementDTO.getEmployeeId(),
            userManagementDTO.getEmployeeName(),
            userManagementDTO.getBirthDate(),
            userManagementDTO.getGender(),
            userManagementDTO.getEmail(),
            new Addresses (userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(),
                new Villages(userManagementDTO.getVillageId())),
            new Educations(userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(),
                new Majors(userManagementDTO.getMajorId()), new Universities(userManagementDTO.getUniversityId())),
            new Contacts(userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(),userManagementDTO.getPhone(),
                userManagementDTO.getLinkedin()),
            new Users(userManagementDTO.getEmployeeId(),userManagementDTO.getUserName(),passwordEncoder.encode(userManagementDTO.getUserPassword()),
                    role)
        );
        
        employeeRepository.save(employee);
        return employee;
    } 
    
    @PostMapping("/loginDTO") //--> nginputin sesuatu pake post
    public LoginDTO loginDTO(@RequestBody DataLoginDTO dataLoginDTO) { //untuk masukin ke request body username + pass masukin apa
        //return myUserDetailService.loginDTO(myUserDetailService.loadByUserName("regita_5", "regita123")); --> getmapping
        return myUserDetailService.loginDTO(dataLoginDTO);
    }
}

