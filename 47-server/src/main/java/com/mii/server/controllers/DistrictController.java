/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.services.DistrictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ROG
 */
@RestController
@ResponseBody
@RequestMapping("districts")
public class DistrictController {

    @Autowired
    DistrictService districtService;
    
    @Autowired
    ProvinceRepository provinceRepository;

    //Get All District Table
    @GetMapping("")
    public List<Districts> getAllDistrict() {
        return districtService.getAll();
    }
    
    //Get District Name and Province Name
    @GetMapping("provdist")
    public List<ProvinceDistrictDTO> getProvDistName() {
        return districtService.getProvinceDistrictName();
    }
    
    //Insert data
    @PostMapping("insert")
    public String insertDistrict(@RequestBody Districts district) {
          if(!provinceRepository.existsById(district.getProvinceId().getProvinceId())) {
              Provinces newProvince = provinceRepository.save(district.getProvinceId());
              district.setProvinceId(newProvince);
          }
          districtService.save(district);
          return "Insert Data Success";
    }
    
    
    //Update data
    @PutMapping("update/{id}")
    public String updateDistrict(@PathVariable Integer id, @RequestBody Districts district) {
        districtService.getByid(id);
        districtService.updateDistrictName(id, district);
        return "Update Success";
    }
    
    //Delete Data
    @DeleteMapping("delete/{id}")
    public String deleteDistrict(@PathVariable Integer id) {
        districtService.deleteDistrictById(id);
        return "Delete Success";
    }
    
}
