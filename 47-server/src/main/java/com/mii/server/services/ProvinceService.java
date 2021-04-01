package com.mii.server.services;

import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        province.add(new Provinces(20,"Papua Aja"));
        province.add(new Provinces(21,"Papua Barat"));
        return provinceRepository.saveAll(province);
    }
//Read
    public List<Provinces>getAll(){
        return provinceRepository.findAll();
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
}