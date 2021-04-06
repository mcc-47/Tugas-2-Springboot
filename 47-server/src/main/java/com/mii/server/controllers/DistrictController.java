/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Districts;
import com.mii.server.services.DistrictService;
import java.util.List;
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
 * @author ACER
 */
@RestController
@RequestMapping("api/districts")
public class DistrictController {
    DistrictService districtService;
    
    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }
    
    @PostMapping("")
    public ResponseEntity<Districts> insertOne(@RequestBody Districts district) {
        return new ResponseEntity<>(districtService.insertOne(district), HttpStatus.OK);
    }
    
    @PostMapping("/list")
    public ResponseEntity<List<Districts>> insertList(@RequestBody List<Districts> districts) {
        return new ResponseEntity<>(districtService.insertAll(districts), HttpStatus.OK);
    }
    
    //Read
    @GetMapping("{id}")
    public ResponseEntity<Districts> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(districtService.getOne(id), HttpStatus.OK);
    }
    
    @GetMapping("")
    public ResponseEntity<List<Districts>> getById() {
        return new ResponseEntity<>(districtService.getAll(), HttpStatus.OK);
    }
    
    //Update
    @PutMapping("{id}")
    public ResponseEntity<?> updateName(@RequestBody Districts district, @PathVariable Integer id) {
        return new ResponseEntity<>(districtService.updateDistrictName(id, district.getKab(), district.getDistrictName()), HttpStatus.OK);        
    }
    
    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        districtService.deleteById(id);
        return new ResponseEntity<>("Berhasil", HttpStatus.OK);
    }
    
    
//    ------------------------------batas restful-------------------------------
//    @GetMapping("/add-dist")
//    public boolean addDistrict() {
//        return districtService.insertOne(new Districts(10, "Kabupaten", "Bantul"));
//    }
//    
//    @GetMapping("/add-dist-all")
//    public void addDistrictAll() {
//        districtService.insertAll(districtService.districtList());
//    }
//    
//    
//    @GetMapping("/read-dist")
//    public List<Districts> readDistrict() {
//        return districtService.getAll();
//    }
//    
//    @GetMapping("/update-dist")
//    public void updateDistrict() {
//        districtService.updateDistrictName(10, "Gunung Kidul");
//    }
//    
//    @GetMapping("/delete-dist")
//    public boolean deleteDistrict() {
//        return districtService.deleteDistrictById(10);
//    }
}
