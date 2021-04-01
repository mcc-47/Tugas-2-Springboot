/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.ProvinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class DistrictService {
    DistrictRepository districtRepository;
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public DistrictService() {
    }

    //Create
    public Districts insertOne(Districts district) {
        if(!provinceRepository.existsById(district.getProvinceId().getProvinceId())) {
            district.setProvinceId(provinceRepository.save(district.getProvinceId()));
        }     
        return districtRepository.save(district);
    }
    
    public List<Districts> insertAll(List<Districts> districtList) {
        for(Districts d:districtList) {
            if(!provinceRepository.existsById(d.getProvinceId().getProvinceId())) {
                d.setProvinceId(provinceRepository.save(d.getProvinceId()));
            }
        }
        return districtRepository.saveAll(districtList);
    } 
    
    //Read
    public List<Districts> getAll() {
        return districtRepository.findAll();
    }
    
    public Districts getOne(Integer id) {
        return districtRepository.findById(id).get();
    }
    
    //Update
    public Districts updateDistrictName(Integer id, String name){
        Districts district = districtRepository.findById(id).get();
        district.setDistrictName(name);
        return districtRepository.save(district);
    }
    
    //Delete
    public boolean deleteById(Integer id) {
        districtRepository.deleteById(id);
        return !districtRepository.existsById(id);
    }
    
    //List bikin manual
//    public List<Districts> districtList() {
//        List<Districts> districts = Arrays.asList(new Districts(),
//                new Districts(),
//                new Districts(),
//                new Districts()
//        );
//        return districts;
//    }
}
