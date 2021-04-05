/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.EmpAllDto;
import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmpAllRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class EmpAllService {
    
    @Autowired
    EmpAllRepository empAllRepository;
    
    public List<EmpAllDto> getAll(){
        List<EmpAllDto> ead = new ArrayList<>();
        for (Employees emp: empAllRepository.findAll()){
            EmpAllDto ed = new EmpAllDto(
                    emp.getEmployeeName(),emp.getGender(),emp.getEmail(),emp.getBirthDate(),
                    emp.getAddresses().getStreet1(),
                    emp.getAddresses().getVillageId().getVillageName(),
                    emp.getAddresses().getVillageId().getZipCode(),
                    emp.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(),
                    emp.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getKab(),
                    emp.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    emp.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName());
            ead.add(ed);
        }
        return ead;
    }

}
