/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.services;

import java.util.List;
import mii.co.id.mcc.entities.Employees;
import mii.co.id.mcc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    
    //CreateOne
    public Employees insertOne(Employees employee) {
        Employees newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }
    
    //CreateMultiple
    public void insertAll(List<Employees> employeeList) {
        employeeRepository.saveAll(employeeList);
    } 
    
    //ReadData
    public List<Employees> getAll() {
        return  employeeRepository.findAll();
    }
    
    //ReadOne
    public List<Employees> getOne(Integer id) {
        return (List<Employees>) employeeRepository.findById(id).get();
    }

}
