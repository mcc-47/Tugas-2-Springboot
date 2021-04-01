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
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafi
 */
@Service
public class ProvinceService {
    
    ProvinceRepository provinceRepository;
    
    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    
    //Create
    public boolean save(Provinces province) {
        Provinces saveProvince = provinceRepository.save(province);
        return provinceRepository.existsById(saveProvince.getProvinceId());
    }
    
    //Read
    public List<Provinces> getAll() {
        return provinceRepository.findAll();
    }
    
    //Read Single Data
    public Provinces getByid(Integer id) {
        return provinceRepository.getOne(id);
    }
    
    //Update
    public void updateProvinceName(Integer id, Provinces province) {
        Provinces prov  = provinceRepository.getOne(id);
        prov.setProvinceName(province.getProvinceName());
        provinceRepository.save(prov);
    }
    
    //Delete
    public boolean deleteProvinceById(Integer id) {
        provinceRepository.deleteById(id);
        return provinceRepository.existsById(id);
    }
}
