/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Employees;
import com.mii.server.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
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
    
    @GetMapping("/list-all")
    public List<Employees> showEmployee(){
        return employeeService.listAll();
    }
    
    @GetMapping("/get-one/{id}")
    public Employees getOneEmployee(@PathVariable Integer id){
        return employeeService.getById(id);
    }
    
    @PutMapping("/update/{id}")
    public Employees updateEmployee(@PathVariable Integer id, @RequestBody Employees employee){
        return employeeService.update(id, employee);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.delete(id);
    }
    
    @PostMapping("/create")
    public Employees createEmployee(@RequestBody Employees employee){
        return employeeService.create(employee);
    }
}
