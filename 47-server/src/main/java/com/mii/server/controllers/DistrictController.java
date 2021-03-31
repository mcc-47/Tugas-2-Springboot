/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.ProvinceDistrictDto;
import com.mii.server.entities.District;
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
@RequestMapping("district")
@RestController
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;

    @PostMapping("")
    public District creat(@RequestBody District district) {
        districtService.saveDistricts(district);
        return district;
    }
    
    @GetMapping("")
    public List<ProvinceDistrictDto> read() {
        return districtService.getAllDistricts();
    }

//    @GetMapping("{id}")
//    public ResponseEntity<District> readById(@PathVariable Integer id) {
//        District district = districtService.getDistrictById(id);
//        return new ResponseEntity<>(district, HttpStatus.OK);
//    }

    @PutMapping("")
    public District updateUsingPut(@RequestBody District district) {
        districtService.saveDistricts(district);
        return district;
    }
    
    @PatchMapping("")
    public District updateUsingPatch(@RequestBody District district) {
        districtService.saveDistricts(district);
        return district;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        districtService.deleteDistrictById(id);
    }
}
