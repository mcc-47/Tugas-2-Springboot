/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.services.DistrictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mii.server.repositories.DistrictRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LENOVO-KL
 */
@RestController
//@RequestMapping("/api/districts")
public class DistrictRestController {
    DistrictService districtService;
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    @Autowired
    DistrictRepository districtRepository;
    
    @Autowired
    public DistrictRestController (DistrictService  districtService){
        this.districtService = districtService;
    }
    //salamAja
    @GetMapping("/hi")
    public String halo(){
       return"Hello Selamat Pagi, Jangan Lupa Tersenyum";
    }
        //read
//    @GetMapping("/dist") //ini tidak bisa (error)
//    public List<Districts> dist(){
//       return districtService.getAll();
//    }
    
    //insert
    @GetMapping("/insert-district")
    public List<Districts > Districts(){
       return districtService.insertDistrict();
    }
    //update
    @GetMapping("/update-district")
    public String updateDistrictName (Integer id, String kab, String name){
        districtService.updateDistrictName(id, name);
    return "Berhasil";
    }
    //delete
    @GetMapping("/dis-delete")
    public String deleteDistrictById (Integer id){
        System.out.println(districtService.deleteDistrictById(id));
        return "Berhasil"; //localhost:8081/
    }
    
    //================================RESTFUL==================================
    //get all
    
    @GetMapping("/list-district") //DTO
    public List<ProvinceDistrictDTO> getProvinceDistrictDTOs(){
        return districtService.getProvinceDistrictName();
    }
    
//    @GetMapping("/d") //ini tidak bisa (error)
//    public List<Districts> list() {
//       return districtService.listAllDistricts();
//    }
//    
    //get by id
    @GetMapping("/disget/{id}")
    public ResponseEntity<Districts> get(@PathVariable(value="id") Integer id) {
        try {
            Districts districts = districtService.getDistricts(id);
            return new ResponseEntity<Districts>(districts,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Districts>(HttpStatus.NOT_FOUND);
        }
    }
    //insert District Province sudah ada
    @PostMapping("/dis-insert")
    public String insertDistrict(@RequestBody Districts districts){
        Districts districtsNew = districtService.saveDistricts(districts);
        return "insert berhasil yes";
    }
    //insert district Yang Province Belum Ada 
    @PostMapping("/dis-save")
    public String add(@RequestBody Districts districts) {
        if (!provinceRepository.existsById(districts.getProvinceId().getProvinceId())){
            Provinces provincesNew = provinceRepository.save(districts.getProvinceId());
            districts.setProvinceId(provincesNew);
        }
       districtRepository.findById(districts.getDistrictId()).get();
       Districts newDistrict= districtService.saveDistricts(districts);
       return "insert district";
    }
    
    //update
    @PutMapping("/dis-update{id}")
    public ResponseEntity<?> update(@RequestBody Districts districts, @PathVariable (value="id") Integer id) {
        try {
            Districts existDistricts = districtService.getDistricts(id);
            districts.setDistrictId(id);
            districts.setKab(districts.getKab());
            districts.setDistrictName(districts.getDistrictName());
            districts.setProvinceId(districts.getProvinceId());
            districtService.saveDistricts(districts);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PatchMapping("/district-update/{id}")
    public ResponseEntity<?> updateDistrict(@PathVariable (value="id")Integer id, @RequestBody Districts districts){
        Districts districts1 = districtService.getDistricts(id);
        districts.setDistrictId(id);
        districts.setKab(districts.getKab());
        districts.setDistrictName(districts.getDistrictName());
        districts.setProvinceId(districts.getProvinceId());
        districtService.saveDistricts(districts);
        return ResponseEntity.ok("berhasil update");
        
    }
    //update 
    @DeleteMapping("/dis-delete{id}")
    public void delete(@PathVariable(value="id") Integer id) {
         districtService.deleteDistrict(id);
    }
}
