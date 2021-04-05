/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;
import com.mii.server.dtos.DistrictProvinceDto;
import com.mii.server.dtos.EmployeeAddressDto;
import com.mii.server.repositories.DistrictRepository;

import com.mii.server.entities.Districts;
import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
@Service
public class DistrictService {
    
    @Autowired
    DistrictRepository districtRepository;
    
    @Autowired
    EmployeeRepository  employeeRepository;
    
    
    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
    
    // Read
    public List<Districts> getAll(){
        List<Districts> districts = new ArrayList<>();
        for (Districts district:districtRepository.findAll()){
        districts.add(new Districts(district.getDistrictId(),district.getDistrictName(),district.getKab(),district.getProvinceId()));
    }
        return districts;
    }
    
    
    public List<DistrictProvinceDto> getAllDisProv() {
        
        List<DistrictProvinceDto> pds = new ArrayList<>();
        for (Districts d : districtRepository.findAll()) {
            DistrictProvinceDto ds = new DistrictProvinceDto(
                    d.getDistrictName(),
                    d.getProvinceId().getProvinceName());
            pds.add(ds);
        }
        return pds;
        
    }
    
    public List<EmployeeAddressDto> getAllEmpAdd(){
        List<EmployeeAddressDto> ead = new ArrayList<>();
        for(Employees emp: employeeRepository.findAll()){
            EmployeeAddressDto ea = new EmployeeAddressDto(
                    emp.getPrefix(),
                    emp.getEmployeeName(),
                    emp.getBirthDate(),
                    emp.getGender(),
                    emp.getEmail()
                  
                   );
            ead.add(ea);
        }
        return ead;
    }
 
    public Districts insertData(Districts districts){
        return districtRepository.save(districts);
    }
    
    public void update(Integer id, Districts districts) {
        Districts district = districtRepository.findById(id).get();
        district.setDistrictName(districts.getDistrictName());
        district.setKab(districts.getKab());
        district.setProvinceId(districts.getProvinceId());
        districtRepository.save(district);
    }

    public Districts getById(Integer id) {
        return districtRepository.getOne(id);
    }
    
    public boolean delete(Integer id){
        districtRepository.deleteById(id);
        return !districtRepository.existsById(id);
    }
    
   
  
    
    // Insert
    /*public List<Districts> insertData() {
        List<Districts> districtses = new ArrayList<>();
        districtses.add(new Districts(1,"Kota","Mantap"));
        return districtRepository.saveAll(districtses);
    }*/
    
    
    //Update
    /*public void update(Integer id, String name){
        Provinces province = serverRepository.findById(id).get();
        province.setProvinceName(name);
        serverRepository.save(province);
    }*/
    
    /*public boolean delete(Integer id){
        districtRepository.deleteById(id);
        return districtRepository.existsById(id);
    }*/
    
    
}
