/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.entities.Provinces;
import com.repositories.ProvinceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class ProvinceService {
    
    
    @Autowired
    ProvinceRepository provinceRepository;

    public ProvinceService() {
    }

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    
    public List<Provinces> listAll(){
        return provinceRepository.findAll();
    }
    
    public Provinces getById(Integer id){
        Optional<Provinces> optional = provinceRepository.findById(id);
        Provinces province = null;
        if (optional.isPresent()) {
            province = optional.get();
        } else {
            throw new RuntimeException("Unfound id: " + id);
        }
        return province;
    }
    
    public Provinces insert(Provinces province){
        return provinceRepository.save(province);
    }
    
    public void update(Integer id, Provinces province){
        Provinces p = provinceRepository.getOne(id);
        p.setProvinceName(province.getProvinceName());
        provinceRepository.save(p);
    }
    
    public void delete(Integer id){
        provinceRepository.deleteById(id);
    }
}
