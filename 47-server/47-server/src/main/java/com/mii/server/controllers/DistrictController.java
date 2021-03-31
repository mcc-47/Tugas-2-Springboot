/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.District;
import com.mii.server.services.DistrictService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author William Yangjaya
 */
@RestController
@RequestMapping(path = "/provinces")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping(path = "/districts")
    public ResponseEntity<List<ProvinceDistrictDTO>> retrieveAllProvinceDistrict(){
        return new ResponseEntity<>(districtService.getProvinceDistrict(), HttpStatus.OK);
    }
    
    /*
    @GetMapping("")
    public ResponseEntity<List<District>> retrieveAllDistricts() {
        return new ResponseEntity<>(districtService.getAllDistricts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> retrieveOneDistrict(@PathVariable Integer id) {
        return new ResponseEntity<>(districtService.getDistrictById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<District> addOneDistrict(@RequestBody District district) {
        return new ResponseEntity<>(districtService.createDistrict(district), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<District> updateOneDistrict(@RequestBody District district, @PathVariable Integer id) {
        return new ResponseEntity<>(districtService.updateDistrictById(district, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOneDistrict(@PathVariable Integer id) {
        try {
            districtService.deleteDistrictById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
}
