/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Provinces;
import com.mii.server.services.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("provinces")
public class ProvinceController {
    ProvinceService provinceService;
    
    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    
    //Create
    @PostMapping("")
    public ResponseEntity<List<Provinces>> insertList(@RequestBody List<Provinces> provinces) {
        provinceService.insertAll(provinces);
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }
    
    //Read
    @GetMapping("")
    public ResponseEntity<List<Provinces>> getAll() {
        return new ResponseEntity<>(provinceService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Provinces> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(provinceService.getOne(id), HttpStatus.OK);
    }
    
    //Update
    @PatchMapping("{id}")
    public ResponseEntity<Provinces> updateName(@RequestBody Provinces province, @PathVariable Integer id) {
        return new ResponseEntity<>(provinceService.updateProvinceName(id, province.getProvinceName()), HttpStatus.OK);        
    }
    
    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        provinceService.deleteById(id);
        return new ResponseEntity<>("Berhasil", HttpStatus.OK);
    }
    
//------------------------------------------------batas rest ful----------------    
//    @GetMapping("/add-prov")
//    public boolean addProvince() {
//        return provinceService.insertOne(new Provinces(17,"Papua Barat"));
//    }
//    
//    @GetMapping("/add-prov-all")
//    public void addProvinceAll() {
//        provinceService.insertAll(provinceService.provinceList());
//    }
//    
//    @GetMapping("/read-prov")
//    public List<Provinces> readProvince() {
//        return provinceService.getAll();
//    }
//    
//    @GetMapping("/update-prov")
//    public void updateProvince() {
//        provinceService.updateProvinceName(17, "Papua");
//    }
//    
//    @GetMapping("/delete-prov")
//    public boolean deleteProvince() {
//        return provinceService.deleteProvinceById(17);
//    }
}
