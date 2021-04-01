/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Districts;
import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.services.DistrictService;
import com.mii.server.services.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zahra
 */
@RestController
public class userController {
    
    ProvinceService provinceService;
    DistrictService districtService;
    ProvinceRepository provinceRepository;
    
    @Autowired
    public userController(ProvinceService provinceService, DistrictService districtService, ProvinceRepository provinceRepository) {
        this.provinceService = provinceService;
        this.districtService = districtService;
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/list-pro")
    public List<Provinces> listUser(){
        return provinceService.getAll();
    }    
    
    @PostMapping ("/insert-pro")
    public boolean addProvince(@RequestBody Provinces province){
        return provinceService.save(province);
    }
    
    @PutMapping("/update-pro")
    public String update(Integer id, String name){
        provinceService.updateProvinceName(id, name);
        return "Ok";
    }
    
    @DeleteMapping("/delete-pro")
    public String delPro(Integer id){
        provinceService.deleteProvinceById(id);
        return "Delete Province Berhasil";
    }    

    @GetMapping("/list-dis")
    public List<Districts> listdistrict(){
        return districtService.getAll();
    }
   
    @PostMapping("/insert-dis")
    public String addDistrict(@RequestBody Districts district){
        if(!provinceRepository.existsById(district.getProvinceId().getProvinceId())){
            Provinces newProvince = provinceRepository.save(district.getProvinceId());
            district.setProvinceId(newProvince);
        }
        Districts newDistrict = districtService.save(district);
        return "insert district";
    }
    
        @PostMapping("/insert-district-province")
    public String saveDistrict(@RequestBody Districts district){
        if (!provinceRepository.existsById(district.getProvinceId().getProvinceId())) {
            Provinces newProvince = provinceRepository.save(district.getProvinceId());
            district.setProvinceId(newProvince);
        } 
        Districts newDistrict = districtService.insert(district);
        return "insert district";
    }

    @PatchMapping("/update-dis")
    public String updatedis(Integer id, String kab, String name){
        districtService.updateDistrict(id,kab,name);
        return "Update Ok";
    }
    
    @DeleteMapping("/delete-dis/{id}")
    public String deletedis(@PathVariable(value="id") Integer id){
        districtService.deleteDistrictById(id);
        return "Delete District";
    }

}
