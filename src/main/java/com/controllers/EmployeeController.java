/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dto.Employee2ContactDto;
import com.dto.Employee2EducationDto;
import com.dto.Employee2ProvinceDto;
import com.dto.EmployeeRegistDto;
import com.entities.Addresses;
import com.entities.Contacts;
import com.entities.Educations;
import com.entities.Employees;
import com.entities.Majors;
import com.entities.Role;
import com.entities.Universities;
import com.entities.Users;
import com.entities.Villages;
import com.services.EmployeeService;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jakab
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    public EmployeeController() {
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/list-all-address")
    public List<Employee2ProvinceDto> showEmployeeAddress(){
        return employeeService.listAllAddress();
    }
    
    @GetMapping("/list-all-contact")
    public List<Employee2ContactDto> showEmployeeContact(){
        return employeeService.listAllContact();
    }
    
    @GetMapping("/list-all-education")
    public List<Employee2EducationDto> showEmployeeEducation(){
        return employeeService.listAllEducation();
    }
    
    //POST BY EMPLOYEE
//    {
//      "birthDate": "2000-03-29T08:22:48.942Z",
//      "degree": "S3",
//      "email": "Karena String",
//      "employeeId": 17,
//      "employeeName": "Usep",
//      "gender": "laki-laki",
//      "linkedin": "GAPUNYA",
//      "majorId": 10,
//      "phone": "0822xxxx0088",
//      "prefix": "MCC",
//      "universityId": 7,
//      "villageId": 10,
//      "userName": "usepkasep",
//      "userPassword": "ulahkituah"
//    }
    @PostMapping("/regist")
    public Employees saveEmployee (@RequestBody EmployeeRegistDto employeeReg){
        return employeeService.insertByEmployee(employeeReg);
    }
    
}
