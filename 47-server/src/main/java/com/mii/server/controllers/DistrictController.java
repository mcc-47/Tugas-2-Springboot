/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.ProvinceDistrictDto;
import com.mii.server.entities.District;
import com.mii.server.entities.Province;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.services.DistrictService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author ASUS
 */
@RestController
@RequestMapping("district")
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    //CREATE
    //insert District --> Province sudah ada
    @PostMapping("")
    public District creat(@RequestBody District district) {
        districtService.saveDistricts(district);
        return district;
    }
    
//    @PostMapping("/insert")
//    public String insertDistrict(@RequestBody District districts){
//       if(!provinceRepository.existsById(districts.getProvince().getProvinceId())){
//           Province newProvince = provinceRepository.save(districts.getProvince());
//           districts.setProvinceId(newProvince);
//       }
//        districtService.saveDistricts(districts);
//        return "insert";
//    }
    
    @PostMapping("/insert")
    public ResponseEntity<District> insertDistrict(@RequestBody District district){
        District districtsNew = districtService.saveDistricts(district);
        return new ResponseEntity(districtsNew, HttpStatus.OK);
    }
    
    //Request Body
//{
//    "districtId": 19,
//    "kotakab": "Kota",
//    "districtName": "Bogor",
//    "provinceId": {
//        "provinceId" : 4,
//        "provinceName": "Jawa Barat"
//    }
//}    
    
    //READ
    @GetMapping("")
    public List<ProvinceDistrictDto> read() {
        return districtService.getAll();
    }
    
    @GetMapping("/no-dto")
    public List<District> read1() {
        return districtService.getAll1();
    }

    @GetMapping("{id}")
    public District readById(@PathVariable Integer id) {
        return districtService.getById(id);
    }

    //UPDATE
    @PutMapping("{id}")
    public District update(@PathVariable Integer id, @RequestBody District district) {
        districtService.getById(id);
        districtService.saveDistricts(district);
        return district;
    }
    
//    @PatchMapping("")
//    public District updateUsingPatch(@RequestBody District district) {
//        districtService.saveDistricts(district);
//        return district;
//    }

    //DELETE
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        districtService.deleteDistrictById(id);
    }
}
