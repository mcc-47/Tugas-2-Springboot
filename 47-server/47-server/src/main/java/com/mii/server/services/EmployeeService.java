/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceToEmployeeDTO;
import com.mii.server.entities.Employee;
import com.mii.server.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author acer
 */
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<ProvinceToEmployeeDTO> getProvinceToEmployee() {
        List<ProvinceToEmployeeDTO> pdsvaes = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            ProvinceToEmployeeDTO pdsvae = new ProvinceToEmployeeDTO(
                    e.getEmployeeName(), e.getBirthDate(), e.getGender(), e.getEmail(),
                    e.getAddress().getStreet1(), e.getAddress().getStreet2(),
                    e.getAddress().getVillageId().getVillageName(), e.getAddress().getVillageId().getZipCode(),
                    e.getAddress().getVillageId().getSubdistrictId().getSubdistrictName(),
                    e.getAddress().getVillageId().getSubdistrictId().getDistrictId().getKotakab(), e.getAddress().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    e.getAddress().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            );
            pdsvaes.add(pdsvae);
        }
        return pdsvaes;
    }
}
