/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;
import com.mii.server.dtos.DistrictProvinceDto;
import com.mii.server.dtos.EmployeeAddressDto;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ServerRepository;
import com.mii.server.services.DistrictService;
import com.mii.server.services.ServerService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author User
 */
@RestController
@RequestMapping("/district")
public class DistrictController {
    
    @Autowired
    DistrictService districtService;
    
    @Autowired
    ServerService serverService;
    
 
    
    @Autowired
    ServerRepository serverRepository;
    
    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }
    
   @GetMapping("")
    public List<Districts> readDistrict(){
        return districtService.getAll();
        
    }
    
//    @PostMapping("/insert")
//    public String insertDistrict(@RequestBody Districts districts){
//        districtService.insertData(districts);
//        return "insert";
//    }
     @PostMapping("/insert")
    public String insertDistrict(@RequestBody Districts districts){
       if(!serverRepository.existsById(districts.getProvinceId().getProvinceId())){
           Provinces newProvince = serverRepository.save(districts.getProvinceId());
           districts.setProvinceId(newProvince);
       }
        districtService.insertData(districts);
        return "insert";
    }
    
    @GetMapping("/disprov")
    public List<DistrictProvinceDto> listDistrict(){

        return districtService.getAllDisProv();
    }
    
    @GetMapping("/empad")
    public List<EmployeeAddressDto> listEmpAdd(@RequestBody Employees employee){
        return districtService.getAllEmpAdd();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Districts> getById(@PathVariable Integer id){
        return new ResponseEntity<>(districtService.getOne(id),HttpStatus.OK);
    }
    
    /*@GetMapping("/insertt")
    public List<Districts> insertDistrict(){
        return districtService.insertData();
    }*/
    
    @DeleteMapping("/delete/{id}")
    public String deleteDistrict(@PathVariable Integer id){
        districtService.delete(id);
        return "berhasil hapus";
    }
    
//    @Delete("/delete/{id}")
//    public String deleteDistrict(@PathVariable Integer id){
//        districtService.delete(id);
//        return "berhasil hapus";
//    }
    
    @PutMapping("/update/{id}")
    public String updateDistrict(@PathVariable Integer id,@RequestBody Districts districts){
        districtService.getById(id);
        districtService.update(id,districts);
        return "updated";
    }
    
    @GetMapping("/dist") //ini tidak bisa (error)
    public List<Districts> dist() {
        return districtService.getAllArnum();
    }
          
    
}
