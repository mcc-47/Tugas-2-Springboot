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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafi 
 */
@RestController
@ResponseBody
@RequestMapping("provinces") //Request mapping ke tabel
public class ProvinceController {
    
    @Autowired
    ProvinceService provinceService;
    
    //GET
    @GetMapping
    public List<Provinces> selectAll() {
        return provinceService.getAll();
    }
    
    //POST
    @PostMapping("/insert")
    public String insert(@RequestBody Provinces province) {
        provinceService.save(province);
        return "Success";
    }
    
    //PUT
    @PutMapping("/update/{id}") //PUT OR PATCHH
    public String updateProvince(@PathVariable Integer id, @RequestBody Provinces province) {
        provinceService.getByid(id);
        provinceService.updateProvinceName(id, province);
        return "Update Success";
    }
    
    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Integer id) {
        provinceService.deleteProvinceById(id);
        return "Success";
    }
}