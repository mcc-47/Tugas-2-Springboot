/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.ProvinceToEmployeeDTO;
import com.mii.server.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping(path = "/provinces/districts/subdistricts/villages/addresses")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public ResponseEntity<List<ProvinceToEmployeeDTO>> retrieveAllProvinceToEmployee() {
        return new ResponseEntity<>(employeeService.getProvinceToEmployee(),HttpStatus.OK);
    }
}
