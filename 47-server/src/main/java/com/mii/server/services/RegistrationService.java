/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;
import com.mii.server.dto.RegistrationDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fadel M Nasution
 */
@Service
public class RegistrationService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    public Employees insertEmployee(RegistrationDTO registrationDTO) {
        Employees regist = new Employees(
                registrationDTO.getPrefix(),
                registrationDTO.getEmployeeId(),
                registrationDTO.getEmployeeName(),
                registrationDTO.getBirthDate(),
                registrationDTO.getGender(),
                registrationDTO.getEmail(),
                new Addresses(
                        registrationDTO.getEmployeeId(), 
                        registrationDTO.getPrefix(), 
                        new Villages(registrationDTO.getVillageId())),
                new Educations(
                        registrationDTO.getEmployeeId(), 
                        new Majors(
                            registrationDTO.getMajorId()), 
                        new Universities(
                            registrationDTO.getUniversityId()),
                            registrationDTO.getPrefix()),
                new Contacts(
                        registrationDTO.getEmployeeId(),
                        registrationDTO.getPhone(),
                        registrationDTO.getLinkedin(), 
                        registrationDTO.getPrefix()));
        return employeeRepository.save(regist);
    }
}
