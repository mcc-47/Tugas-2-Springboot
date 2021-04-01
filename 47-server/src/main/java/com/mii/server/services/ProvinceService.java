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
 * @author LENOVO-KL
 */
@Service
public class ProvinceService {
    ProvinceRepository provinceRepository;
    
    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }
    
    public void saveAll(List<Provinces> provin){
            provinceRepository.saveAll(provin);
    }
//insert
    public List<Provinces> insertData(){
        List<Provinces> province = new ArrayList<>();
        province.add(new Provinces(8,"Jaya Pura"));
        province.add(new Provinces(9,"NTT"));
        province.add(new Provinces(10,"NTB"));
        province.add(new Provinces(11,"Ternate"));
        
        return provinceRepository.saveAll(province);
    }
//Read
    public List<Provinces>getAll(){
//        return provinceRepository.findAll();
          List<Provinces> prov = new ArrayList<>();
          for (Provinces provinces : provinceRepository.findAll()){
              prov.add(new Provinces(provinces.getProvinceId(), provinces.getProvinceName()));
          }
        return prov;
    }
//Update --> Update
    public void updateProvinceName(Integer id, String name){
        Provinces province = provinceRepository.findById(id).get();
        province.setProvinceName(name);
        provinceRepository.save(province);
    }
    
//Delete --> Delete
    public boolean deleteProvinceById(Integer id){
        provinceRepository.deleteById(id);
        return !provinceRepository.existsById(id);
    }
 //================================RESTFUL===================================
 //get data 
    public List<Provinces> listAllProvinces(){
        return provinceRepository.findAll();
    }
//insert data
    public void saveProvinces(Provinces provinces){
        provinceRepository.save(provinces);
    }
//update data
    public Provinces getProvinces(Integer id){
        return provinceRepository.findById(id).get();
    }
 //delete data 
    public void deleteProvinces(Integer id){
        provinceRepository.deleteById(id);
    }
}

//province.add(new Provinces(1,"Banten"));
//        province.add(new Provinces(2,"Daerah Istimewa Yogyakarta"));
//        province.add(new Provinces(3,"DKI Jakarta"));
//        province.add(new Provinces(4,"Jawa Barat"));
//        province.add(new Provinces(5,"Jawa Tengah"));
//        province.add(new Provinces(6,"Riau"));
//        province.add(new Provinces(7,"Sumatera Selatan"));
//        province.add(new Provinces(8,"Sulawesi Utara"));
//        province.add(new Provinces(9,"Sumatera Barat"));
//        province.add(new Provinces(10,"Sulawesi Selatan"));
//        province.add(new Provinces(11,"Papua"));