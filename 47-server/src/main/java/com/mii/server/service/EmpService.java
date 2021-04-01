/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.service;

import com.mii.server.dtos.EmpDTO;
import com.mii.server.entity.Employees;
import com.mii.server.repositories.EmpRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MyLaptop
 */
@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;
    
     EmpRepository employeeRepository;
    
    @Autowired
    public EmpService(EmpRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
 public Employees saveEmploy (Employees employees){
     return employeeRepository.save(employees);
 }
        
//    public List<EmpDTO> getAllEmp(){
//        List<EmpDTO> add = new ArrayList<>();
//      
//    }
//            
}
