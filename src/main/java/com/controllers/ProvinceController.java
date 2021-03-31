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
    
    //MENU
//    @GetMapping("/")
//    public String homePage(){
//        System.out.println("Hello World");  //console
//        return "Hello World";               //browser
//    }
    
    //READ
    //postman -> localhost:8082/provinces/list-all
    @GetMapping("/list-all")
    public List<Provinces> listProvince(){
        for (Provinces province : provinceService.listAll()) {
            System.out.printf("\nID      : %d",province.getProvinceId());
            System.out.printf("\nName    : %s",province.getProvinceName());
            System.out.println("");
        }
        return provinceService.listAll();
    }
    
    //CREATE
    //postman -> localhost:8082/provinces/insert
//    {
//        "provinceId": 10,
//        "provinceName": "Bali"
//    }
    @PostMapping("/insert")
    public String saveProvince(@RequestBody Provinces province){
        Provinces newProvince = provinceService.insert(province);
        System.out.printf("\nID      : %d",newProvince.getProvinceId());
        System.out.printf("\nName    : %s",newProvince.getProvinceName());
        System.out.println("");
        return "insert province";
    }
    
    //UPDATE
    //postman -> localhost:8082/provinces/update/12
//    {
//        "provinceId": 12,
//        "provinceName": "Aceh"
//    }
    @PutMapping("/update/{id}") //PUT/PATCH
    public String updateProvince(@PathVariable Integer id,
            @RequestBody Provinces province){
        Provinces oldProvince = provinceService.getById(id);
        System.out.println("\nFrom this");
        System.out.printf("ID      : %d",oldProvince.getProvinceId());
        System.out.printf("\nName  : %s",oldProvince.getProvinceName());
        System.out.println("");
        provinceService.update(id,province);
        province = provinceService.getById(id);
        System.out.println("\nTo this");
        System.out.printf("ID      : %d",province.getProvinceId());
        System.out.printf("\nName  : %s",province.getProvinceName());
        System.out.println("");
        return "update province";
    }
    
    //DELETE
    //postman -> localhost:8082/provinces/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Integer id){
        Provinces province = provinceService.getById(id);
        System.out.println("Delete this");
        System.out.printf("\nID      : %d",province.getProvinceId());
        System.out.printf("\nName    : %s",province.getProvinceName());
        System.out.println("");
        provinceService.delete(id);
        return "delete province";
    }
    
}
