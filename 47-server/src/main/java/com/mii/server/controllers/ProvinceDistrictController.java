
package com.mii.server.controllers;

import com.mii.server.dto.ProvinceDistrictDTO;


import com.mii.server.services.ProvinceDistrictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/api")
public class ProvinceDistrictController {
    
    @Autowired
    private ProvinceDistrictService provinceDistrictService;
    
    @GetMapping("/disprov")
    public List<ProvinceDistrictDTO> listDistrict(){

        return provinceDistrictService.getAllDisProv();
    }
}
