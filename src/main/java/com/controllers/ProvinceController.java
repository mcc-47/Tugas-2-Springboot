/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.entities.Provinces;
import com.services.ProvinceService;
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
@RequestMapping("/api/provinces")
public class ProvinceController {
    
    @Autowired
    ProvinceService provinceService;

    public ProvinceController() {
    }

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    
    //READ
    //postman -> localhost:8082/provinces/list-all
    @GetMapping("/list-all")
    public List<Provinces> listProvince(){
        return provinceService.listAll();
    }
    
    //CREATE
    //postman -> localhost:8082/provinces/insert
//    {
//        "provinceId": 10,
//        "provinceName": "Bali"
//    }
    @PostMapping("/insert")
    public Provinces saveProvince(@RequestBody Provinces province){
        return provinceService.insert(province);
    }
    
    //UPDATE
    //postman -> localhost:8082/provinces/update/12
//    {
//        "provinceId": 12,
//        "provinceName": "Aceh"
//    }
    @PutMapping("/update/{id}") //PUT/PATCH
    public Provinces updateProvince(@PathVariable Integer id,
            @RequestBody Provinces province){
        provinceService.update(id,province);
        return provinceService.getById(id);
    }
    
    //DELETE
    //postman -> localhost:8082/provinces/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Integer id){
        provinceService.delete(id);
        return "delete province";
    }
    
}
