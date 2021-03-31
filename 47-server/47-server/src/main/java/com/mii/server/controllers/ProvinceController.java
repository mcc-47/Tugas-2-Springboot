/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Province;
import com.mii.server.services.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping(path = "/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ResponseEntity<List<Province>> retrieveAllProvinces() {
        return new ResponseEntity<>(provinceService.getAllProvinces(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return province name by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Province> retrieveOneProvince(@PathVariable Integer id) {
        return new ResponseEntity<>(provinceService.getProvinceById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Province> addOneProvince(@RequestBody Province province) {
        return new ResponseEntity<>(provinceService.createProvince(province), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> updateOneProvince(@RequestBody Province province, @PathVariable Integer id) {
        return new ResponseEntity<>(provinceService.updateProvinceById(province, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOneProvince(@PathVariable Integer id) {
        try {
            provinceService.deleteProvinceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
