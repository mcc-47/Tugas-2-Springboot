/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.RegistDTO;
import com.mii.server.entities.Address;
import com.mii.server.entities.Contact;
import com.mii.server.entities.Education;
import com.mii.server.entities.Employee;
import com.mii.server.entities.Major;
import com.mii.server.entities.University;
import com.mii.server.entities.Village;
import com.mii.server.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class RegistServiceImpl implements RegistService{

    EmployeeRepository employeeRepository;

    @Autowired
    public RegistServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee insertData(RegistDTO registDTO) {
        Employee nreg = new Employee(
                registDTO.getPrefix(),
                registDTO.getEmployeeId(),
                registDTO.getEmployeeName(),
                registDTO.getBirthDate(),
                registDTO.getGender(),
                registDTO.getEmail(),
                new Address(registDTO.getEmployeeId(), registDTO.getPrefix(), new Village(registDTO.getVillageId())),
                new Education(registDTO.getEmployeeId(), new Major(registDTO.getMajorId()), new University(registDTO.getUniversityId()), registDTO.getPrefix()),
                new Contact(registDTO.getEmployeeId(),registDTO.getPhone(),registDTO.getLinkedin(),registDTO.getPrefix()));
        return employeeRepository.save(nreg);
    }

}
