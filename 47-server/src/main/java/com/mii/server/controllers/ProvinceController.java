 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Province;
import com.mii.server.services.ProvinceService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
 * @author ASUS
 */


//@Controller
@RequestMapping("province")
@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public List<Province> read() {
        System.out.println(provinceService.getAllProvinces());
        return provinceService.getAllProvinces();
    }

//    @GetMapping("{id}")
//    public ResponseEntity<Province> readById(@PathVariable Integer id) {
//        Province province = provinceService.getProvinceById(id);
//        return new ResponseEntity<>(province, HttpStatus.OK);
//    }

    @PostMapping("")
    public ResponseEntity<?> creat(@RequestBody Province province) {
        provinceService.saveProvince(province);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public Province updateUsingPut(@RequestBody Province province) {
        provinceService.saveProvince(province);
        return province;
    }
    
    @PatchMapping("")
    public Province updateUsingPatch(@RequestBody Province province) {
        provinceService.saveProvince(province);
        return province;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id) {
        provinceService.deleteProvinceById(id);
        return "Data berhasil dihapus!";
    }
}