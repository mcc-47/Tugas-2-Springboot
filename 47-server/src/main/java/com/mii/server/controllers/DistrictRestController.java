/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Districts;
import com.mii.server.entities.Provinces;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.services.DistrictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController 
public class DistrictRestController {
    DistrictService districtService;
    
    @Autowired
    DistrictRepository districtRepository;
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    
   @Autowired
   public DistrictRestController(DistrictService districtService){
       this.districtService = districtService;
   }
   
   @GetMapping("/hallo")
   public String halo(){
       return"Hallo Selamat Pagi, Have A Nice Day";
   }
   
   @GetMapping("/district")
   public List<Districts >Districts(){
       return districtService.insertData();
   }
   
   @GetMapping("update_district")
   public String updateDistrictName (Integer id, String kab, String name){
       districtService.updateDistrictName(id, name);
       return "Berhasil";
   }
   
   @GetMapping("delete_district")
   public String deleteDistrictById (Integer id){
       System.out.println(districtService.deleteDistrictById(id));
       return "Berhasil";
   }

   @PostMapping("save")
   public String save(@RequestBody Districts district){
       if(!provinceRepository.existsById(district.getProvinceId().getProvinceId())){
           Provinces newProvince = provinceRepository.save(district.getProvinceId());
           district.setProvinceId(newProvince);
       }
        districtRepository.findById(district.getDistrictId()).get();
        Districts newDistrict = districtService.insert(district);
        return "insert_district";
   }
   
}
