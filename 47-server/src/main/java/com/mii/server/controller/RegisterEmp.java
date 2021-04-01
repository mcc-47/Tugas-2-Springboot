/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controller;

import com.mii.server.dtos.UserManagementDTO;
import com.mii.server.entity.Addresses;
import com.mii.server.entity.Contacts;
import com.mii.server.entity.Educations;
import com.mii.server.entity.Employees;
import com.mii.server.entity.Majors;
import com.mii.server.entity.Universities;
import com.mii.server.entity.Villages;
import com.mii.server.repositories.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MyLaptop
 */
@RestController
public class RegisterEmp {

    UserManagementRepository userManagementRepository;
    UserManagementDTO userManagementDTO;

    @Autowired

    public RegisterEmp(UserManagementRepository userManagementRepository) {
        this.userManagementRepository = userManagementRepository;
    }

    @PostMapping("/register")
    public Employees saveEmployee(UserManagementDTO userManagementDTO) {
        Employees employee = new Employees(
                userManagementDTO.getPrefix(),
                userManagementDTO.getEmployeeId(),
                userManagementDTO.getEmployeeName(),
                userManagementDTO.getBirthDate(),
                userManagementDTO.getGender(),
                userManagementDTO.getEmail(),
                new Addresses(userManagementDTO.getPrefix(), userManagementDTO.getEmployeeId(),
                        new Villages(userManagementDTO.getVillageId())),
                new Educations(userManagementDTO.getPrefix(), userManagementDTO.getEmployeeId(),
                        new Majors(userManagementDTO.getMajorId()), new Universities(userManagementDTO.getUniversityId())),
                new Contacts(userManagementDTO.getEmployeeId(), userManagementDTO.getPrefix(), userManagementDTO.getPhone(),
                        userManagementDTO.getLinkedin()));
        userManagementRepository.save(employee);
        return employee;
    }
}
