/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    //Create
    public Employees insertOne(Employees employee) {
        Employees newEmployee = employeeRepository.save(employee);
//        return employeeRepository.existsById(newEmployee.getEmployeeId());
        return newEmployee;
    }
    
    public void insertAll(List<Employees> employeeList) {
        employeeRepository.saveAll(employeeList);
    }
    
    //Read
    public Employees getOne(Integer id) {
        return employeeRepository.findById(id).get();
    }
    
    public List<Employees> getAll() {
        return employeeRepository.findAll();
    }

    //Update
    
    
    //Delete
    
    
}
