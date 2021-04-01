/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ProvinceService {
    
    ProvinceRepository provinceRepository;
    
    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    
    //Create
    public boolean insertOne(Provinces province) {
        Provinces newProvince = provinceRepository.save(province);
        return provinceRepository.existsById(newProvince.getProvinceId());
    }
    
    public void insertAll(List<Provinces> provinceList) {
        provinceRepository.saveAll(provinceList);
    } 
    
    //Read
    public List<Provinces> getAll() {
        return provinceRepository.findAll();
    }
    
    //error di controller, request method not allowed
//    public Provinces getById(Integer id) {
//        return provinceRepository.getOne(id);
//    }
    
    public Provinces getOne(Integer id) {
        return provinceRepository.findById(id).get();
    }
    
    //Update
    public Provinces updateProvinceName(Integer id, String name){
        Provinces province = provinceRepository.findById(id).get();
        province.setProvinceName(name);
        return provinceRepository.save(province);
    }
    
    //Delete
    public boolean deleteById(Integer id) {
        provinceRepository.deleteById(id);
        return !provinceRepository.existsById(id);
    }
    
//    public boolean deleteProvinceByName(String name) {
//        provinceRepository.delete();
//        return !provinceRepository.existsById(id);
//    }
    
    //List
    public List<Provinces> provinceList() {
        List<Provinces> provinces = Arrays.asList(
                new Provinces(1, "Sumatera Barat"),
                new Provinces(2, "Sumatera Utara"),
                new Provinces(3, "Bali"),
                new Provinces(4, "NTB")
        );
        return provinces;
    }
}
