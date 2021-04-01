/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.EmpAdsDTO;
import com.mii.server.entities.Employees;
import com.mii.server.services.EmpAdsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping ("/api")
public class EmpAdsController {
    
    @Autowired
    private EmpAdsService empAdsService;
    
    @GetMapping("/empads")
    public List<EmpAdsDTO> listEmployee(){

        return empAdsService.getAllEmpAds();
    }
}
