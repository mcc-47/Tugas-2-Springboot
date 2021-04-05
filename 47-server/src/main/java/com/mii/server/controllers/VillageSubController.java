/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.VillageSubDto;
import com.mii.server.services.VillageSubService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/vilsub")
public class VillageSubController {
    @Autowired
    private VillageSubService villageSubService;
    
    @GetMapping("")
    public List<VillageSubDto> listtVillSub(){
        return villageSubService.getAll();
    }
}
