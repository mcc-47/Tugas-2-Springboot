/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.RegistDto;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class RegistService {
   
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    public RegistService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    
    
        public Employees insertData(RegistDto registdto){
        List<Role> role =   new ArrayList<>();
        role.add(new Role(2, "trainer"));
                
        Employees nreg = new Employees(
                registdto.getPrefix(),
                registdto.getEmployeeId(),
                registdto.getEmployeeName(),
                registdto.getBirthDate(),
                registdto.getGender(),
                registdto.getEmail(),
                new Addresses(registdto.getEmployeeId(),registdto.getPrefix(),new Villages(registdto.getVillageId())),
                new Educations(registdto.getEmployeeId(),new Majors(registdto.getMajorId()),new Universities(registdto.getUniversityId()), registdto.getPrefix()),
                new Contacts(registdto.getEmployeeId(),registdto.getPhone(),registdto.getLinkedin(),registdto.getPrefix()),
                new Users(registdto.getEmployeeId(),registdto.getUserName(),passwordEncoder.encode(registdto.getUserPassword()),
                        role)
       
        );
                
//                new Addresses(registdto.getVillageId(),registdto.getPrefix()),
//                new Educations(new Majors(registdto.getMajorId()),new Universities(registdto.getUniversityId())),
//                new Contacts(registdto.getPrefix(),registdto.getPhone(),registdto.getLinkedin()));
//            Role role = new Role(3,"Trainer");

        return employeeRepository.save(nreg);
        }
    }
//        

//(registdto.getEmployeeName(),registdto.getBirthDate(),registdto.getGender(),registdto.getEmail(),
//                new Addresses(registdto.getVillageId()),
//                new Educations(registdto.get),
//                new Contacts(registdto.getEm, prefix, phone, linkedin)contacts)
        
//            (registdto.getEmployeeName(),registdto.getBirthDate(),registdto.getGender(),registdto.getEmail(),
//                
//                new Addresses(Integer.BYTES,registdto.getVillageId()),
//                new Educations(Integer.SIZE,registdto.getMajorId()),
//                new Contacts(Integer.MIN_VALUE,registdto.getPhone(),registdto.getLinkedin()));
        
        
        
//        (registdto.getEmployeeName(),registdto.getBirthDate(),registdto.getGender(),registdto.getEmail(), 
//                registdto.getPhone(),registdto.getLinkedin(),
//                new Addresses(registdto.getVillageId(),
//                 Integer.SIZE,registdto.getMajorId(),Integer.MAX_VALUE,registdto.getUniversityId() Integer.SIZE)
//        registdto.getEmployeeName(),
//        registdto.getBirthDate(),
//        registdto.getGender(),
//        registdto.getEmail());
        
        
   
