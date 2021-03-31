/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dto.Employee2ContactDto;
import com.dto.Employee2EducationDto;
import com.dto.Employee2ProvinceDto;
import com.entities.Addresses;
import com.entities.Employees;
import com.repositories.AddressRepository;
import com.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeerepository;
    
//    @Autowired
//    AddressRepository addressRepository;

    public EmployeeService() {
    }

    public EmployeeService(EmployeeRepository employeerepository) {
        this.employeerepository = employeerepository;
    }
    
    public List<Employee2ProvinceDto> listAllAddress(){
        List<Employees> employees = employeerepository.findAll();
        List<Employee2ProvinceDto> listAddressEmployee = new ArrayList<>();
        for (Employees emps : employees) {
            Employee2ProvinceDto forListEmp = new Employee2ProvinceDto(
                    emps.getPrefix(), 
                    emps.getEmployeeId(), 
                    emps.getEmployeeName(),
                    emps.getBirthDate(), 
                    emps.getGender(), 
                    emps.getEmail(), 
                    emps.getAddresses().getStreet1(), 
                    emps.getAddresses().getStreet2(), 
                    emps.getAddresses().getVillageId().getVillageName(), 
                    emps.getAddresses().getVillageId().getZipCode(), 
                    emps.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(), 
                    emps.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(), 
                    emps.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName());
            listAddressEmployee.add(forListEmp);
        }
        return listAddressEmployee;
    }
    
    public List<Employee2ContactDto> listAllContact(){
        List<Employees> employees = employeerepository.findAll();
        List<Employee2ContactDto> listContactEmployee = new ArrayList<>();
        for (Employees emps : employees) {
            Employee2ContactDto forListCont = new Employee2ContactDto(
                    emps.getPrefix(),
                    emps.getEmployeeId(), 
                    emps.getEmployeeName(), 
                    emps.getBirthDate(), 
                    emps.getGender(), 
                    emps.getEmail(), 
                    emps.getContacts().getPhone(), 
                    emps.getContacts().getLinkedin());
            listContactEmployee.add(forListCont);
        }
        return listContactEmployee;
    }
    
    public List<Employee2EducationDto> listAllEducation(){
        List<Employees> employees = employeerepository.findAll();
        List<Employee2EducationDto> listEducationEmployee = new ArrayList<>();
        for (Employees emps : employees) {
            Employee2EducationDto forListEduc = new Employee2EducationDto(
                    emps.getPrefix(),
                    emps.getEmployeeId(), 
                    emps.getEmployeeName(), 
                    emps.getBirthDate(), 
                    emps.getGender(), 
                    emps.getEmail(), 
                    emps.getEducations().getDegree(), 
                    emps.getEducations().getMajorId().getMajorName(),
                    emps.getEducations().getUniversityId().getUniversityName());
            listEducationEmployee.add(forListEduc);
        }
        return listEducationEmployee;
    }
    
    //by employee
    public Employees insertByEmployee (Employees employee){
        return employeerepository.save(employee);
    }
    
    //by address
//    public Addresses insertByAddress(Addresses address){
//        return addressRepository.save(address);
//    }
}
