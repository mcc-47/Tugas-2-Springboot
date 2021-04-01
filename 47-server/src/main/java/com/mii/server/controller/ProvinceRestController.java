/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controller;

import com.mii.server.entity.Provinces;
import com.mii.server.service.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MyLaptop
 */
    @RestController 
public class ProvinceRestController {
    ProvinceService provinceService;

   @Autowired
   public ProvinceRestController(ProvinceService provinceService){
       this.provinceService = provinceService;
   }
   @GetMapping("/all")
   public List<Provinces> provin(){
       return provinceService.getAll();
   }

   @GetMapping("")
   public String halo(){
       return"New new";
   }
   @GetMapping("insert_province")
   public List<Provinces> provinceses(){
       return provinceService.insertData();
   }
   @PostMapping("/insert")
   public String saveProvince(@RequestBody Provinces provin){
       Provinces newProvinces = provinceService.insert(provin);
       return "insert provin";
   }
   @GetMapping("update_province")
    public String updateProvinceName (Integer id, String name){
        provinceService.updateProvinceName(id, name);
    return "redirect:/";
    }
    @GetMapping("/delete")
    public String deletePersonById (Integer id){
        System.out.println(provinceService.deleteProvinceById(id));
        return "redirect:/"; //localhost:8081/
    }
    
}
