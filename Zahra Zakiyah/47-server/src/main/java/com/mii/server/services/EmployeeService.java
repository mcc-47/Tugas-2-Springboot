/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zahra
 */
@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeerepository;
   
    public List<Employees> listAll(){
        return employeerepository.findAll();
    }
    
    public Employees getById(Integer employeeId){
        return employeerepository.findById(employeeId).get();
    }
    
    public void delete(Integer employeeId){
        employeerepository.deleteById(employeeId);
    }
    
    public Employees update(Integer employeeId, Employees employees){
        Employees newEmp = employeerepository.findById(employeeId).get();
        newEmp.setEmployeeName(employees.getEmployeeName());
        newEmp.setBirthDate(employees.getBirthDate());
        newEmp.setGender(employees.getGender());
        newEmp.setEmail(employees.getEmail());
        return employeerepository.save(newEmp);
    }
    
    public Employees create(Employees employee){
        return employeerepository.save(employee);
    }
    
}
