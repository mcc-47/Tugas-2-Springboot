/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.service;

import com.mii.server.entity.Districts;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MyLaptop
 */

 @Service
public class DistrictService {
    DistrictRepository districtRepository;
    
    @Autowired
    public DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    public void saveAll(List<Districts> district){
            districtRepository.saveAll(district);
    }
//insert
    public List<Districts> insertData(){
        List<Districts> district = new ArrayList<>();
        return districtRepository.saveAll(district);
    }
//Read
    public List<Districts>getAll(){
        return districtRepository.findAll();
    }
//Update --> Update
    public void updateDistrictName(Integer id, String name){
        Districts district = districtRepository.findById(id).get();
        district.setDistrictName(name);
        districtRepository.save(district);
    }
    //Delete --> Delete
    public boolean deleteDistrictById(Integer id){
        districtRepository.deleteById(id);
        return !districtRepository.existsById(id);
    }
    
    public Districts insert (Districts district){
        return districtRepository.save(district);
    }
}
