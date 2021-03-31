/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.RegistDTO;
import com.mii.server.entities.Employee;
import com.mii.server.services.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping(path = "/registration")
public class RegistController {

    @Autowired
    private RegistService registService;

    @PostMapping("")
    public ResponseEntity<Employee> saveUser(@RequestBody RegistDTO registDTO) {
        return new ResponseEntity<>(registService.insertData(registDTO), HttpStatus.OK);
    }

    /*
    {
        "prefix":"MCC",
        "employeeId":14,
        "employeeName":"Willtestregist",
        "birthDate":"2010-10-10",
        "gender":"Laki-laki",
        "email":"mcc472021@gmail.com",
        "phone":"0892929292",
        "linkedin":"test",
        "villageId":11,
        "majorId":1,
        "universityId":8
    }
     */
}
