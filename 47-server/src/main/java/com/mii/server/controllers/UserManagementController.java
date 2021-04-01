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
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.VillageRepository;
import com.mii.server.services.EmployeeService;
import com.mii.server.services.NotificationService;
import com.mii.server.services.UserManagementService;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO-KL
 */
@RestController
//@RequestMapping("/api/user")
public class UserManagementController {
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
    NotificationService notificationService;
    
    @Autowired 
    public UserManagementController(UserManagementService userManagementService){
        this.userManagementService = userManagementService;
       
}
    @GetMapping("/user-list")
    public List<UserManagementDTO> getUserManagementDTOs(){
        return userManagementService.getUserManagementDTOs();
    }
    
    @GetMapping("/data")
    @ResponseBody
    public List<UserManagementDTO> getAllUserManagementDTOs(){
        List<UserManagementDTO> userManagement = userManagementService.getAlluser();
        return userManagement;
    }
    @PostMapping("/ada")
    public Employees createDTO(@RequestBody UserManagementDTO userManagementDTO){
        Employees employ = userManagementService.saveUser(userManagementDTO);
        return employ;
    }

    @PostMapping("/ins")
    public Employees saveEmployee(@RequestBody UserManagementDTO userManagementDTO){
           Employees empl = userManagementService.saveEmployee(userManagementDTO);
     return empl;
}
    @PostMapping("/demoemail{employeeId}")
    public ResponseEntity<?> sendEmail(@PathVariable (value="employeeId") Integer employeeId)throws MessagingException{
        if (employeeId == null){
            return new ResponseEntity("Please Insert employee Id",(HttpStatus.NOT_ACCEPTABLE));
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity(true,HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/loginyuk")
    public void testLogin(){
        System.out.println("test permitAll");
        
    }
    
}




