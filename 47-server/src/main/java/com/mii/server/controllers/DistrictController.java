/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.services.DistrictService;
import com.mii.server.dto.ProvinceDistrictDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fadel M Nasution
 */
@RestController
@RequestMapping("api/districts")
public class DistrictController {
    
    @Autowired
    public DistrictService districtService;
    
    @GetMapping
    public List<ProvinceDistrictDTO> selectAll() {
        return districtService.getDistrictAll();
    }
}
