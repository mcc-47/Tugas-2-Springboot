
package com.mii.server.controllers;

import com.mii.server.dto.SubVillageDTO;
import com.mii.server.services.SubVillageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/api")
public class SubVillageController {
    @Autowired
    private SubVillageService subVillageService;
    
    @GetMapping("/subvil")
    public List<SubVillageDTO> listVillage() {
        
        return subVillageService.getAllSubVil();
    }
}