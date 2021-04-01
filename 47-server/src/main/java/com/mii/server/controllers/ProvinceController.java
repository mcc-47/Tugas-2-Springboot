package com.mii.server.controllers;

import com.mii.server.entities.Provinces;
import com.mii.server.services.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/")
    public String hello() {
        return "Hello, world";
    }

    //create
    @PostMapping("/insert")
    public void province(@RequestBody Provinces province) {
        System.out.println("=== Data province berhasil ditambahkan ===");
        provinceService.insert(province);
    }

    //read
    @GetMapping("/view")
    public List<Provinces> getAllProvince() {
        System.out.println("=== Berhasil melihat seluruh data province ===");
        return provinceService.getAll();
    }

    //read by id
    @GetMapping("/{provinceId}")
    public Provinces getById(@PathVariable Integer provinceId) {
        System.out.println("=== Berhasil melihat data berdasarkan id province ====");
        return provinceService.getById(provinceId);

    }
    
    //update
    @PatchMapping("/update")
    public void updateProvince(Integer provinceId, String provinceName) {
        System.out.println(" === Data province berhasil diubah ===");
        provinceService.update(provinceId, provinceName);
    }
    

    //delete
    @DeleteMapping("{provinceId}")
    public void deleteProvince(@PathVariable Integer provinceId) {
        System.out.println("=== Data province berhasil dihapus ===");
        provinceService.delete(provinceId);

    }
}