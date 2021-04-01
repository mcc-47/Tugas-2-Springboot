/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.DataEmployeeDTO;
import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fadel M Nasution
 */
@Service
public class DataEmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<DataEmployeeDTO> getData() {
        
        List<Employees> emp = employeeRepository.findAll();
        
        List<DataEmployeeDTO> data = new ArrayList<>();
        
        for (Employees e : emp) {
            DataEmployeeDTO ead = new DataEmployeeDTO(
                e.getEmployeeName(),
                e.getAddresses().getStreet1(),
                e.getAddresses().getVillageId().getVillageName(),
                e.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(),
                e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName());
                
            data.add(ead);    
        }
        return data;
        
        
    }
}
