/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.controller;

import  mii.co.id.mcc.entities.Provinces;
import java.util.List;
import mii.co.id.mcc.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ROG
 */
@RestController
@RequestMapping("province")
public class ProvinceController {
    
    @Autowired
    ProvinceService provinceService;
    
    @GetMapping("")
    public List<Provinces> getAll() {
        return provinceService.getAll();
    }
}
