/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.ProvinceToSubdistrictDTO;
import com.mii.server.services.SubdistrictService;
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
@RequestMapping(path = "/provinces/districts/")
public class SubdistrictController {

    @Autowired
    private SubdistrictService subdistrictService;

    @GetMapping(path = "/subdistricts")
    public ResponseEntity<List<ProvinceToSubdistrictDTO>> retrieveAllProvinceToSubdistrict() {
        return new ResponseEntity<>(subdistrictService.getProvinceToSubdistrict(), HttpStatus.OK);
    }

}
