/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.RegisterDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Users;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.AddressRepository;
import com.mii.server.repositories.ContactRepository;
import com.mii.server.repositories.EducationRepository;
import com.mii.server.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class RegisterService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    AddressRepository addressRepository;
    
    @Autowired
    EducationRepository educationRepository;
    
    @Autowired
    ContactRepository contactRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    //read
    public RegisterDTO getOne(Integer id) {
        Employees e = employeeRepository.findById(id).get();
        RegisterDTO user = new RegisterDTO(
                e.getPrefix(),
                id,
                e.getEmployeeName(), 
                e.getBirthDate(), 
                e.getGender(), 
                e.getEmail(), 
                e.getAddresses().getVillageId().getVillageId(), 
                e.getContacts().getPhone(), 
                e.getContacts().getLinkedin(), 
                e.getEducations().getMajorId().getMajorId(), 
                e.getEducations().getUniversityId().getUniversityId(),
                e.getUsers().getUsername(),
                e.getUsers().getPassword()
        );
        return user;
    }
    
    //insert
    public Employees insertOne(RegisterDTO registerDTO) {
        String newEmployeePrefix = registerDTO.getPrefix();
        Integer newEmployeeId = registerDTO.getIdEmployee();
        
        Employees newEmployee = new Employees(
                newEmployeeId,
                newEmployeePrefix,
                registerDTO.getNameEmployee(), 
                registerDTO.getBirthdate(), 
                registerDTO.getGender(), 
                registerDTO.getEmail(), 
                new Addresses(
                        newEmployeeId,
                        newEmployeePrefix,
                        new Villages(registerDTO.getVillageId())), 
                new Educations(
                        newEmployeeId,
                        newEmployeePrefix,
                        new Majors(registerDTO.getMajorId()), 
                        new Universities(registerDTO.getUniversityId())), 
                new Contacts(
                        newEmployeeId,
                        newEmployeePrefix,
                        registerDTO.getPhone(), 
                        registerDTO.getLinkedin()),
                new Users(
                        newEmployeeId, 
                        registerDTO.getUserName(), 
                        passwordEncoder.encode(registerDTO.getPassword()))
        );
        return employeeRepository.save(newEmployee);
    }
}
