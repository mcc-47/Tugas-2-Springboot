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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author LENOVO-KL
 */
@RestController 
//@RequestMapping("/api/provinces")
public class ProvinceRestController {
    ProvinceService provinceService;
    
   @Autowired
    public ProvinceRestController(ProvinceService provinceService){
       this.provinceService = provinceService;
    }
    //Read 
    @GetMapping("/province-list")
    public List<Provinces> provin(){
       return provinceService.getAll();
    }
    
    //SalamAja
    @GetMapping("/halo")
    public String halo(){
       return"Hallo Selamat Pagi,Apa Kabar Hari ini?";
    }
    
    //Insert Data
    @GetMapping("/insert-province")
    public List<Provinces> provinceses(){
       return provinceService.insertData();
    }
    
    //update Data
    @GetMapping("/update-province")
    public String updateProvinceName (Integer id, String name){
        provinceService.updateProvinceName(id, name);
    return "Berhasil Update";
    }
    
    //delete data
    @GetMapping("/delete")
    public String deletePersonById (Integer id){
        System.out.println(provinceService.deleteProvinceById(id));
        return "Berhasil Delete"; //localhost:8081/
    }

    //============================RESTFUL======================================
    //get Data
    @GetMapping("/listprovince")
    public List<Provinces> list() {
        return provinceService.listAllProvinces();
    }
    //get by id 
    @GetMapping("/provinceby{id}")
    public ResponseEntity<Provinces> get(@PathVariable(value="id") Integer id) {
        try {
            Provinces provinces = provinceService.getProvinces(id);
            return new ResponseEntity<Provinces>(provinces, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Provinces>(HttpStatus.NOT_FOUND);
        }
    }
    
    //insert data    
    @PostMapping("/prov")
    public void add(@RequestBody Provinces provinces) {
        provinceService.saveProvinces(provinces);
    }
    
    //update data
    @PutMapping("/upd{id}")
    public ResponseEntity<?> update(@RequestBody Provinces provinces, @PathVariable(value="id") Integer id) {
        try {
            Provinces existProvinces = provinceService.getProvinces(id);
            provinces.setProvinceId(id);
            provinceService.saveProvinces(provinces);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/updt{id}")
    public ResponseEntity<?> updateProvince(@PathVariable(value="id") Integer id, @RequestBody Provinces provinces){
        Provinces updateProv = provinceService.getProvinces(id);
        provinces.setProvinceId(id);
        provinceService.saveProvinces(provinces);
        return ResponseEntity.ok("berhasil update");
        
    }
    
    //delete data 
    @DeleteMapping("/dlt{id}")
    public void delete(@PathVariable Integer id) {
         provinceService.deleteProvinces(id);
    }
   
}
