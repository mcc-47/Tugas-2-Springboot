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
//import com.entities.Districts;
import com.entities.Educations;
import com.entities.Employees;
import com.entities.Majors;
//import com.entities.Provinces;
//import com.entities.Subdistricts;
import com.entities.Universities;
import com.entities.Users;
import com.entities.Villages;
//import com.repositories.AddressRepository;
//import com.repositories.ContactRepository;
//import com.repositories.DistrictRepository;
//import com.repositories.EducationRepository;
//import com.repositories.EmployeeRepository;
//import com.repositories.MajorRepository;
//import com.repositories.ProvinceRepository;
//import com.repositories.SubdistrictRepository;
//import com.repositories.UniversityRepository;
//import com.repositories.VillageRepository;
import com.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
//    @Autowired
//    EmployeeRepository employeeRepository;
//    
//    @Autowired
//    AddressRepository addressRepository;
//    
//    @Autowired
//    VillageRepository villageRepository;
//    
//    @Autowired
//    SubdistrictRepository  subdistrictRepository;
//    
//    @Autowired
//    DistrictRepository districtRepository;
//    
//    @Autowired
//    ProvinceRepository provinceRepository;
//    
//    @Autowired
//    EducationRepository educationRepository;
//    
//    @Autowired
//    MajorRepository majorRepository;
//    
//    @Autowired
//    UniversityRepository universityRepository;
//    
//    @Autowired
//    ContactRepository contactRepository;
    
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
//      "villageId": 10
//    }
    @PostMapping("/insert-by-employee")
    public String saveEmployee (@RequestBody EmployeeRegistDto employeeReg){
        Employees newEmployee = new Employees(
                employeeReg.getPrefix(),
                employeeReg.getEmployeeId(),
                employeeReg.getEmployeeName(),
                employeeReg.getBirthDate(),
                employeeReg.getGender(),
                employeeReg.getEmail(),
                new Addresses(employeeReg.getEmployeeId(), employeeReg.getPrefix(), new Villages(employeeReg.getVillageId())),
                new Educations(employeeReg.getEmployeeId(), employeeReg.getPrefix(), employeeReg.getDegree(), new Majors(employeeReg.getMajorId()), new Universities(employeeReg.getUniversityId())),
                new Contacts(employeeReg.getEmployeeId(), employeeReg.getPrefix(),employeeReg.getPhone(), employeeReg.getLinkedin()),
                new Users(employeeReg.getEmployeeId(), employeeReg.getUserName(), passwordEncoder.encode(employeeReg.getUserPassword())));
        employeeService.insertByEmployee(newEmployee);  
        return "insert employee";
    }
//    @PostMapping("/insert-by-employee")
//    public String saveEmployee (@RequestBody EmployeeRegistDto employeeReg){
//        Employees newEmployee = new Employees(
//                employeeReg.getPrefix(),
//                employeeReg.getEmployeeId(),
//                employeeReg.getEmployeeName(),
//                employeeReg.getBirthDate(),
//                employeeReg.getGender(),
//                employeeReg.getEmail());
//                newEmployee.setAddresses(
//                        new Addresses(
//                                newEmployee.getEmployeeId(), 
//                                employeeReg.getPrefix(), 
//                                new Villages(employeeReg.getVillageId())));
//                newEmployee.setEducations(
//                        new Educations(
//                                newEmployee.getEmployeeId(), 
//                                employeeReg.getPrefix(), 
//                                employeeReg.getDegree(), 
//                                new Majors(employeeReg.getMajorId()), 
//                                new Universities(employeeReg.getUniversityId())));
//                newEmployee.setContacts(
//                        new Contacts(
//                                newEmployee.getEmployeeId(), 
//                                employeeReg.getPrefix(),
//                                employeeReg.getPhone(), 
//                                employeeReg.getLinkedin()));
//        employeeService.insertByEmployee(newEmployee);
//        return "insert employee";
//    }
    
    //POST BY ADDRESS
//    {
//      "addressId": 14,
//      "employees": {
//        "prefix": "MCC",
//        "employeeId": 14,
//        "employeeName": "Wawan Waaw",
//        "birthDate": "2021-03-29T01:25:27.672Z",
//        "gender": "laki-laki",
//        "email": "string"
//      },
//      "prefix": "MCC",
//      "street1": "Wadaw Super No.1 RT01/RW02",
//      "street2": "Komplek Hiro",
//      "villageId": {
//        "villageId": 14,
//        "villageName": "Kiromang",
//        "zipCode": "90896",
//        "subdistrictId": {
//          "subdistrictId": 14,
//          "subdistrictName": "Kokorobet",
//          "districtId": {
//            "districtId": 12,
//            "kab": "Kota",
//            "districtName": "Walung Poh",
//            "provinceId": {
//              "provinceId": 10,
//              "provinceName": "Aceh"
//            }
//          }
//        }
//      }
////    }
//    @PostMapping("/insert-to-address")
//    public String saveEmployeeByAddress(@RequestBody Addresses address){
//        if (!employeeRepository.existsById(address.getEmployees().getEmployeeId())) {
//            Employees newEmployee = employeeRepository.save(address.getEmployees());
//            address.setEmployees(newEmployee);
//            address.setAddressId(address.getEmployees().getEmployeeId());
//        }
//        if (!provinceRepository.existsById(address.getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceId())) {
//            Provinces newProvince = provinceRepository.save(address.getVillageId().getSubdistrictId().getDistrictId().getProvinceId());
//            address.getVillageId().getSubdistrictId().getDistrictId().setProvinceId(newProvince);
//        }
//        if (!districtRepository.existsById(address.getVillageId().getSubdistrictId().getDistrictId().getDistrictId())) {
//            Districts newDistrict = districtRepository.save(address.getVillageId().getSubdistrictId().getDistrictId());
//            address.getVillageId().getSubdistrictId().setDistrictId(newDistrict);
//        }
//        if (!subdistrictRepository.existsById(address.getVillageId().getSubdistrictId().getSubdistrictId())) {
//            Subdistricts newSubdistric = subdistrictRepository.save(address.getVillageId().getSubdistrictId());
//            address.getVillageId().setSubdistrictId(newSubdistric);
//        }
//        if (!villageRepository.existsById(address.getVillageId().getVillageId())) {
//            Villages newVillage = villageRepository.save(address.getVillageId());
//            address.setVillageId(newVillage);
//        }
//        Addresses newEmployeeByAddress = employeeService.insertByAddress(address);
//        return "insert employee by address";
//    }
    
}
