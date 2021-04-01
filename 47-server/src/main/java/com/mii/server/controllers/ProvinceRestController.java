package com.mii.server.controllers;

import com.mii.server.entities.Provinces;
import com.mii.server.services.ProvinceService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
       return"Hello Selamat Malam";
   }
   @GetMapping("insert_province")
   public List<Provinces> provinceses(){
       return provinceService.insertData();
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