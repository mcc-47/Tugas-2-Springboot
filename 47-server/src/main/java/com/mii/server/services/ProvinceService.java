/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fadel M Nasution
 */
@Service
public class ProvinceService {
    @Autowired
    public ProvinceRepository provinceRepository;
    
   
    //CREATE
    public boolean insertData(Provinces province) {
        Provinces savedProvince = provinceRepository.save(province);
        return provinceRepository.existsById(savedProvince.getProvinceId());
    }
    
    //READ
    public List<Provinces> getAll() {
        return provinceRepository.findAll();
    }
     
    //UPDATE
    public void updateData(Integer id, Provinces province){
        province.setProvinceId(province.getProvinceId());
        province.setProvinceName(province.getProvinceName());
        provinceRepository.save(province);
    }
  
    //DELETE
    public boolean deleteData(Integer id) {
        provinceRepository.deleteById(id);
        return provinceRepository.existsById(id);
    }
}
