/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.EmployeeProvinceDto;
import com.mii.server.dto.RegistrationDto;
import com.mii.server.entities.Employee;
import com.mii.server.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RequestMapping("")
@RestController
public class EmployeeControler {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/EmployeeProvince")
    public List<EmployeeProvinceDto> read(){
        return employeeService.getAll();
    }
    
    
    @PostMapping("")
    public String creat(@RequestBody RegistrationDto registrationDto) {
        employeeService.saveRegistration(registrationDto);
        return "Berhasil";
    }
    
//    @PostMapping("")
//    public String creat(@RequestBody Employee employee) {
//        employeeService.saveRegistration(employee);
//        return "Berhasil";
//    }
    
    
}
