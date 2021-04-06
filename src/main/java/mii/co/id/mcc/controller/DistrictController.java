/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.controller;

import java.util.List;
import javax.mail.MessagingException;
import static javax.print.PrintServiceLookup.registerService;
import mii.co.id.mcc.dto.RegisterDTO;
import mii.co.id.mcc.entities.Districts;
import mii.co.id.mcc.services.DistrictService;
import mii.co.id.mcc.services.RegisterService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ROG
 */
@RestController
@RequestMapping("api/districts")
public class DistrictController {
    
    @Autowired
    DistrictService districtService;
    
    @Autowired
    RegisterService registerService;
    
    @GetMapping("")
    public List<Districts> getAll() {
        return districtService.getAll();
    }
    
    @PostMapping("")
    public ResponseEntity<Districts> insert(@RequestBody Districts district) {
        return new ResponseEntity<>(districtService.insert(district), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Districts> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(districtService.getOne(id), HttpStatus.OK);
    }
    
//    @PutMapping("{id}")
//    public ResponseEntity<?> updateName(@RequestBody Districts district, @PathVariable Integer id) {
//        return new ResponseEntity<>(districtService.updateDistrictName(id, district.getKab(), district.getDistrictName()), HttpStatus.OK);         
//    }
    
    //UpdateMapping
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Districts district, @PathVariable Integer id) {
        return new ResponseEntity<>(districtService.updateDistrict(id, district.getKab(), district.getDistrictName(), district.getProvinceId()), HttpStatus.OK);        
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        districtService.delete(id);
        return new ResponseEntity<>("Delete Berhasil", HttpStatus.OK);
    }
}
