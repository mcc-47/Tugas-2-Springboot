/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Province;
import com.mii.server.repositories.ProvinceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    
    public Province getProvinceById(Integer id) {
        Optional<Province> optional = provinceRepository.findById(id);
        Province province = null;
        if (optional.isPresent()) {
            province = optional.get();
        } else {
            throw new RuntimeException(" Province not found for id :: " + id);
        }
        return province;
    }

    
    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    
    public Province updateProvinceById(Province provinceDetails, Integer id) {
        Province province = this.getProvinceById(id);
        province.setProvinceId(province.getProvinceId());
        province.setProvinceName(provinceDetails.getProvinceName());
        return provinceRepository.save(province);
    }

    
    public void deleteProvinceById(Integer id) {
        this.provinceRepository.deleteById(id);
    }

}
