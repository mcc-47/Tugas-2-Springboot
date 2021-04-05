/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.UserManagementDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class UserManagementService {
    
    @Autowired
    UserManagementRepository userManagementRepository;
    
    
    //Create data for Multiple Table
    public Employees insertData(UserManagementDTO userManagementDTO) {
        Employees reg = new Employees(
                userManagementDTO.getPrefix(), 
                userManagementDTO.getEmployeeId(), 
                userManagementDTO.getEmployeeName(), 
                userManagementDTO.getBirthDate(), 
                userManagementDTO.getGender(), 
                userManagementDTO.getEmail(),
                new Addresses(
                        userManagementDTO.getPrefix(), 
                        userManagementDTO.getEmployeeId(), 
                        new Villages(
                                userManagementDTO.getVillageId()
                        )
                ), 
                new Educations(
                        userManagementDTO.getEmployeeId(), 
                        new Majors(
                                userManagementDTO.getMajorId()
                        ), 
                        new Universities(
                                userManagementDTO.getUniversityId()
                        ),
                        userManagementDTO.getPrefix()
                ), 
                new Contacts(
                        userManagementDTO.getEmployeeId(), 
                        userManagementDTO.getPhone(), 
                        userManagementDTO.getLinkedin(), 
                        userManagementDTO.getPrefix()
                )
        );
        return userManagementRepository.save(reg);
    }
    
    
}
