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
    
    EmployeeRepository employeeRepository;

    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
/*    public List<Employees> getAll(){
        List<Employees> e = new ArrayList<>();
        for (Employees employee : employeeRepository.findAll()){
           e.add(new Employees("MCC",employee.getEmployeeId(),employee.getEmployeeName(), employee.getBirthDate(), employee.getGender(), employee.getEmail()));
        };
        return e;
    }
*/    
    
    
}
