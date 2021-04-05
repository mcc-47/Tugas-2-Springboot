/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.EmpAllDto;
import com.mii.server.services.EmpAllService;
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
@RequestMapping("/empall")
public class EmpAllController {
    @Autowired
    private EmpAllService empAllService;
    
    @GetMapping("")
    public List<EmpAllDto> list(){
        return empAllService.getAll();
    }
}
