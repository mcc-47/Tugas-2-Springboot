/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Provinces;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;

/**
 *
 * @author LENOVO-KL
 */
@Service
public class DistrictService {
    DistrictRepository districtRepository;
    
    @Autowired
    public DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }
//saveAll
    public void saveAll(List<Districts> district){
            districtRepository.saveAll(district);
    }
//insert
    public List<Districts> insertDistrict(){
        List<Districts> district = new ArrayList<>();
        district.add(new Districts(15, "Kota","Ubud",new Provinces(1)));
        return districtRepository.saveAll(district);
    }

//Read  
    public List<Districts>getAll(){
//        return districtRepository.findAll();
          List<Districts> dist = new ArrayList<>();
          for (Districts districts : districtRepository.findAll()){
              dist.add(new Districts(districts.getDistrictId(),districts.getKab(),districts.getDistrictName(),
              districts.getProvinceId()));
          }
        return dist;
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

//=====================================RESTFUL==================================    
    
//Get All / Read
    public List<Districts> listAllDistricts(){
        return districtRepository.findAll(); 
    }
    
//insert data
    public Districts saveDistricts (Districts districts){
        return districtRepository.save(districts);
    }
//update
     public Districts getDistricts(Integer id){
        return districtRepository.findById(id).get();
    }

//delete data 
    public void deleteDistrict(Integer id){
        districtRepository.deleteById(id);
    }

//DTO 
    public List<ProvinceDistrictDTO> getProvinceDistrictName(){
        districtRepository.findAll();
        List<ProvinceDistrictDTO> pds = new ArrayList<>();
        for (Districts d : districtRepository.findAll()){
            ProvinceDistrictDTO pd = new ProvinceDistrictDTO (
            d.getDistrictId(), d.getDistrictName(), d.getProvinceId().getProvinceName());
            pds.add(pd);
        }
        return pds;
    }

    
}
   
//        district.add(new Districts(1, "Kota","Bandung" ));
//        district.add(new Districts(2, "Kota","Bekasi" ));
//        district.add(new Districts(3, "Kab.","Bekasi" ));
//        district.add(new Districts(4, "Kota","Jakarta Barat" ));
//        district.add(new Districts(5, "Kota","Jakarta Timur" ));
//        district.add(new Districts(6, "Kota","Jakarta Utara" ));
//        district.add(new Districts(7, "Kota","Palembang" ));
//        district.add(new Districts(8, "Kota","PekanBaru" ));
//        district.add(new Districts(9, "Kab.","Semarang" ));
//        district.add(new Districts(10, "Kab.","Sleman" ));
//        district.add(new Districts(11, "Kab.","Tangerang" ));