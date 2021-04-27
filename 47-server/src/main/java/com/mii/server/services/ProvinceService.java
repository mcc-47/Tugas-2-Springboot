/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Province;
import com.mii.server.repositories.ProvinceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    //READ
    public List<Province> getAll() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Integer id) {
        return provinceRepository.findById(id).get();
    }
    
    //CREATE
    public void saveProvince(Province province) {
        this.provinceRepository.save(province);
    }

    //UPDATE
    public void update(Integer id, Province provinces) {
        Province p = provinceRepository.findById(id).get();
        p.setProvinceName(provinces.getProvinceName());
        provinceRepository.save(p);
    }

    //DELETE
    public String delete(Integer id) {
        provinceRepository.deleteById(id);
        return "Success";
    }
}
