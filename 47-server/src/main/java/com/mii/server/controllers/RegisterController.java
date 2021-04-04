/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.UserManagementDTO;
import com.mii.server.entities.Employees;
import com.mii.server.repositories.AddressRepository;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.EmployeeRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.VillageRepository;
import com.mii.server.services.EmployeeService;
import com.mii.server.services.NotificationService;
import com.mii.server.services.UserManagementService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO-KL
 */
@RestController
//@RequestMapping("/api/regis")
public class RegisterController {
    UserManagementService userManagementService;
    EmployeeService employeeService;
    
    @Autowired
    EmployeeRepository employeeRepository;
    AddressRepository addressRepository;
    VillageRepository villageRepository;
    SubdistrictRepository subdistrictRepository;
    DistrictRepository districtRepository;
    
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    NotificationService notificationService;
    

    public RegisterController(UserManagementService userManagementService, EmployeeService employeeService) {
        this.userManagementService = userManagementService;
        this.employeeService = employeeService;
    }
    @PostMapping("/registrasi")
    public String saveEmp(@RequestBody UserManagementDTO userManagementDTO) throws MessagingException{
           userManagementService.saveEmployee(userManagementDTO);
           
//           Users users = new Users();
//           users.setRolesList(Arrays.asList(roleRepository.findByRoleName("admin")));
//           Role role = roleRepository.findByRoleName("trainer");
//           Users users = new Users();
//           users.setRolesList((List<Role>) role);
           
//           notificationService.sendEmail(userManagementDTO.getEmployeeId());
           return "bisa nih";
    } 
}
