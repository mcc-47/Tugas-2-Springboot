/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zahra
 */

@Service
public class DistrictService {
    
    @Autowired
    DistrictRepository districtRepository;

    public DistrictService() {
    }

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
    

    //Create
/*    public List<Districts> insertData(){
        List<Districts> district = new ArrayList<>();
        district.add(new Districts(12, "kota", "Bandung",1));
        district.add(new Districts(12, "kota", "Bandung",1));
        district.add(new Districts(13, "kota", "Bandung",1));
        
        return districtRepository.saveAll(district);
    }*/
    public Districts save(Districts district){
        return districtRepository.save(district);
        
//        return districtRepository.existsById(dis.getDistrictId());
    }
    
    public Districts insert(Districts district){
        return districtRepository.save(district);
    }
    //Read
    public List<Districts> getAll(){
        List<Districts> dis = new ArrayList<>();
      
        for (Districts district : districtRepository.findAll()){
           dis.add(new Districts(district.getDistrictId(), district.getKab(), district.getDistrictName(), district.getProvinceId()));
        };
        return dis;
//        return districtRepository.findAll();
    }
    
    //Update
    public void updateDistrict(Integer districtId, String kab, String districtName){
        Districts district = districtRepository.findById(districtId).get();
        district.setKab(kab);
        district.setDistrictName(districtName);
        districtRepository.save(district);
    }

    
    //Delete
    public boolean deleteDistrictById(Integer districtId){
        districtRepository.deleteById(districtId);
        return !districtRepository.existsById(districtId);
    }
    

}
