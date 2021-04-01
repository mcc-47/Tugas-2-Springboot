/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zahra
 */

@Service
public class ProvinceService {
    
    ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    
    //Create
    public List<Provinces> insertData(){
        List<Provinces> province = new ArrayList<>();
        province.add(new Provinces(9, "Percobaan 1"));
        province.add(new Provinces(10, "Percobaan 2"));

        return provinceRepository.saveAll(province);
    }
    public boolean save(Provinces province){
        Provinces pro = provinceRepository.save(province);
        return provinceRepository.existsById(pro.getProvinceId());
    }
//    public void insertone(){
//        return provinceRepository.save(province);
//    }
    //Read
    public List<Provinces> getAll(){
        List<Provinces> pro = new ArrayList<>();
      
        for (Provinces province : provinceRepository.findAll()){
           pro.add(new Provinces(province.getProvinceId(), province.getProvinceName()));
        };
        return pro;

//        return provinceRepository.findAll();
    }
    public Provinces getOne(Integer id){
        return provinceRepository.getOne(id);
    }
    
    //Update
    public void updateProvinceName(Integer provinceId, String provinceName){
        Provinces province = provinceRepository.findById(provinceId).get();
        province.setProvinceName(provinceName);
        provinceRepository.save(province);
    }
    
    //Delete
    public boolean deleteProvinceById(Integer provinceId){
        provinceRepository.deleteById(provinceId);
        return !provinceRepository.existsById(provinceId);
    }

}
