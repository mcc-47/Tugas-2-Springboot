
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
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    
    //create
    public Provinces insert(Provinces province) {
        return provinceRepository.save(province);
    }

    //Read
    public List<Provinces> getAll() {
        List<Provinces> pro = new ArrayList<>();
        for (Provinces province : provinceRepository.findAll()) {
            pro.add(new Provinces(province.getProvinceId(), province.getProvinceName()));
        }
        return pro;
    }
    
    //read by id 
    public Provinces getById(Integer provinceId) {
        Provinces pro = provinceRepository.findById(provinceId).get();
        return pro;
    }
    
    
    //Update
    public void update(Integer provinceId, String provinceName) {
        Provinces province = provinceRepository.getOne(provinceId);
        province.setProvinceId(provinceId);
        province.setProvinceName(provinceName);
        provinceRepository.save(province);
    }
    
    //delete
    public void delete(Integer provinceId) {
        provinceRepository.deleteById(provinceId);
    }
   
}
