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
 * @author ASUS
 */
@Service
public class ProvinceService{

    @Autowired
    private ProvinceRepository provinceRepository;
    
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public void saveProvince(Province province) {
        this.provinceRepository.save(province);
    }
    
    public Province addProvince(Province addProvince) {
        return provinceRepository.save(addProvince);
    }

    public Province getProvinceById(Integer id) {
        Optional<Province> optional = provinceRepository.findById(id);
        Province provinces = null;
        if(optional.isPresent()){
            provinces = optional.get();
        }
        else{
            throw new RuntimeException(" Province not found for id :: " + id);
        }
        return provinces;
    }

    public void deleteProvinceById(Integer id) {
        this.provinceRepository.deleteById(id);
    }
}
