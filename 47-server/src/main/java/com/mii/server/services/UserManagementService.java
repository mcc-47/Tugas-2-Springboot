/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.EmpAdsDTO;
import com.mii.server.dto.UserManagementDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Universitys;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.EmpAdsRepository;
import com.mii.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ASUS
 */
@Service
public class UserManagementService extends ApplicationSecurityService {
    
    @Autowired
    EmpAdsRepository empAdsRepository;
    
    @Autowired 
    private UserRepository userRepository;
    
    @Autowired
    private ApplicationSecurityService applicationSecurityService;
    
    public String saveEmployee (@RequestBody UserManagementDTO umDTO) {
        Employees emp = new Employees (
                umDTO.getPrefix(),
                umDTO.getEmployeeId(),
                umDTO.getEmployeeName(),
                umDTO.getBirthDate(),
                umDTO.getGender(),
                umDTO.getEmail(),
                
                new Educations(umDTO.getEmployeeId(), umDTO.getPrefix(), umDTO.getDegree(), new Majors(umDTO.getMajorId()), new Universitys(umDTO.getUniversityId())),
                new Contacts(umDTO.getEmployeeId(), umDTO.getPrefix(), umDTO.getPhone(), umDTO.getLinkedin()),
                new Addresses(umDTO.getEmployeeId(), umDTO.getPrefix(), new Villages(umDTO.getVillageId())));

                
               empAdsRepository.save(emp);
               return "data berhasil disimpan";
    }
   
}
