/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dto.ProvinceDistrictDto;
import com.entities.Districts;
import com.entities.Provinces;
import com.repositories.DistrictRepository;
import com.repositories.ProvinceRepository;
import com.services.DistrictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jakab
 */
@RestController
@RequestMapping("/api/districts")
public class DistrictController {
    
    @Autowired
    DistrictService districtService;
    
    public DistrictController() {
    }

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }
    
    //READ - GET v
    //postman -> localhost:8082/districts/list-all
    @GetMapping("/list-all")
    public List<ProvinceDistrictDto> showDistrict(){
        return districtService.listAll();
    }
    
    //CREATE - POST
    //postman -> localhost:8082/districts/insert
//    {
//    "districtId": 12,
//    "kab": "Kab.",
//    "districtName": "Sumedang",
//    "provinceId": {
//        "provinceId": 4,  --> 20
//        "provinceName": "wadaww"
//        }
//    }
    @PostMapping("/insert")
    public Districts saveDistrict(@RequestBody Districts district){
        return districtService.insert(district);
    }
    
    //UPDATE - PATCH/PUT
    //postman -> localhost:8082/districts/update/20
//    {
//    "districtId": 20,
//    "kab": "Kab.",
//    "districtName": "Jongol",
//    "provinceId": {
//        "provinceId": 3
//        }
//    }
    @PutMapping("/update/{id}")
    public Districts updateDistrict(@PathVariable Integer id, 
            @RequestBody Districts district)throws Exception{
        return districtService.update(id, district);
    }
    
    //DELETE - DELETE v
    //postman -> localhost:8082/districts/delete/18
    @DeleteMapping("/delete/{id}")
    public String deleteDistrict(@PathVariable Integer id){
        districtService.delete(id);
        return "delete district";
    }
    
}
