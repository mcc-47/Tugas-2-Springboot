package com.mii.server.controllers;

import com.mii.server.dto.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Provinces;
import com.mii.server.services.DistrictService;
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
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    //create
    @PostMapping("/insert")
    public String district(@RequestBody Districts district) {
        System.out.println("--- Data district berhasil ditambah ---");
        districtService.insert(district);
        return "Data berhasil ditambahkan";
    }

    //read, ok
    @GetMapping("/view")
    public List<Districts> getAllDistrict() {
        System.out.println("--- Berhasil melihat seluruh data district ---");
        return districtService.getAll();
    }

    //read by id, OK
    @GetMapping("/{districtId}")
    public Districts getById(@PathVariable Integer districtId) {
        System.out.println("--- Berhasil melihat data district berdasarkan id --- ");
        return districtService.getById(districtId);
    }

    //update
    @PatchMapping("/update")
    public String updateDistrict(Integer districtId, String districtName, String kab, Integer provinceId) {
        System.out.println("--- Data district berhasil diupdate ---");
        districtService.update(districtId, districtName, kab, provinceId);
        return "Data district berhasil diubah";
    }

    //delete, OK
    @DeleteMapping("{districtId}")
    public void deleteDistrict(@PathVariable Integer districtId) {
        System.out.println("Data district berhasil dihapus");
        districtService.delete(districtId);

    }
    
}
