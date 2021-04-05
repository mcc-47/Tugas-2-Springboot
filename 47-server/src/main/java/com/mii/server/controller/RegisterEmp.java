/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controller;

import com.mii.server.dtos.UserManagementDTO;
import com.mii.server.entity.Addresses;
import com.mii.server.entity.Contacts;
import com.mii.server.entity.Educations;
import com.mii.server.entity.Employees;
import com.mii.server.entity.Majors;
import com.mii.server.entity.Universities;
import com.mii.server.entity.Villages;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.repositories.RoleRepository;
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.UserManagementRepository;
import com.mii.server.repositories.VillagesRepository;
import com.mii.server.service.EmpService;
import com.mii.server.service.NotificationService;
import com.mii.server.service.UserManagementService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MyLaptop
 */
@RestController
public class RegisterEmp {

    UserManagementRepository userManagementRepository;
    UserManagementDTO userManagementDTO;

    @Autowired

    public RegisterEmp(UserManagementRepository userManagementRepository) {
        this.userManagementRepository = userManagementRepository;
    }

    @PostMapping("/register")
    public Employees saveEmployee(UserManagementDTO userManagementDTO) {
        Employees employee = new Employees(
                userManagementDTO.getPrefix(),
                userManagementDTO.getEmployeeId(),
                userManagementDTO.getEmployeeName(),
                userManagementDTO.getBirthDate(),
                userManagementDTO.getGender(),
                userManagementDTO.getEmail(),
                new Addresses(userManagementDTO.getPrefix(), userManagementDTO.getEmployeeId(),
                        new Villages(userManagementDTO.getVillageId())),
                new Educations(userManagementDTO.getPrefix(), userManagementDTO.getEmployeeId(),
                        new Majors(userManagementDTO.getMajorId()), new Universities(userManagementDTO.getUniversityId())),
                new Contacts(userManagementDTO.getEmployeeId(), userManagementDTO.getPrefix(), userManagementDTO.getPhone(),
                        userManagementDTO.getLinkedin()));
        userManagementRepository.save(employee);
        return employee;
    }

    @RequestMapping("/api/regis")
//@RequestMapping("/api/regis")
    public class RegisterController {

        UserManagementService userManagementService;
        EmpService employeeService;


            VillagesRepository villageRepository;
            SubdistrictRepository subdistrictRepository;
            DistrictRepository districtRepository;

            @Autowired
            ProvinceRepository provinceRepository;
            @Autowired
            RoleRepository roleRepository;

            @Autowired
            NotificationService notificationService;

                @PostMapping("/registrasi")
                public Employees saveEmp(@RequestBody UserManagementDTO userManagementDTO) throws MessagingException {
                    Employees empl = userManagementService.saveEmployee(userManagementDTO);

//           Users users = new Users();
//           users.setRolesList(Arrays.asList(roleRepository.findByRoleName("admin")));
//           Role role = roleRepository.findByRoleName("trainer");
//           Users users = new Users();
//           users.setRolesList((List<Role>) role);
                    notificationService.sendEmail(userManagementDTO.getEmployeeId());
                    return empl;
                }
            }
     @Autowired
    NotificationService notificationService;
    
    @Autowired 

    public RegisterController(UserManagementService userManagementService, EmployeeService employeeService) {
        this.userManagementService = userManagementService;
        this.employeeService = employeeService;
    }
    @PostMapping("/registrasi")
    public Employees saveEmp(@RequestBody UserManagementDTO userManagementDTO) throws MessagingException{
           Employees empl = userManagementService.saveEmployee(userManagementDTO);
    public String saveEmp(@RequestBody UserManagementDTO userManagementDTO) throws MessagingException{
           userManagementService.saveEmployee(userManagementDTO);
           
//           Users users = new Users();
//           users.setRolesList(Arrays.asList(roleRepository.findByRoleName("admin")));
 public class RegisterController {
//           Users users = new Users();
//           users.setRolesList((List<Role>) role);
           
           notificationService.sendEmail(userManagementDTO.getEmployeeId());
           return empl;
//           notificationService.sendEmail(userManagementDTO.getEmployeeId());
           return "bisa nih";
    } 
}
        }
