/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.services.ProvinceService;
import com.mii.server.entities.Provinces;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Fadel M Nasution
 */
@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    
    @Autowired
    public ProvinceService provinceService;
    
//    @GetMapping("")
//    public String ViewHome() {
//        return "index";
//    }
    
    @GetMapping("/get-all")
    public List<Provinces> selectProvinces() {
        System.out.println("\n");
        System.out.println("=====List of Provinces=====");
        System.out.println("Province Id   Province Name  ");
        System.out.println("=================================");
        for (Provinces provinces : provinceService.getAll()) {
            System.out.println(String.format("         %d  |   %s", provinces.getProvinceId(), provinces.getProvinceName()));
        }
        return provinceService.getAll();
    }
    
    @PostMapping("/insert")
    public String insertProvinces(@RequestBody Provinces province) {
        provinceService.insertData(province);
        return "Data Added";
    }

    @PutMapping("/update/{id}")
    public String updateProvinces(@PathVariable Integer id, @RequestBody Provinces province){
        provinceService.updateData(id, province);
        return "Data Updated";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteProvinces(@PathVariable Integer id) {
        provinceService.deleteData(id);
        return "Data Deleted";
    }
}

