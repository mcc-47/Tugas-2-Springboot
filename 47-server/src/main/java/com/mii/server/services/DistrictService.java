/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.ProvinceDistrictDto;
import com.mii.server.entities.District;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class DistrictService{
    
    @Autowired
    private DistrictRepository districtRepository;

//    public List<District> getAllDistricts() {
//        return districtRepository.findAll();
//    }
    
    public List<ProvinceDistrictDto> getAllDistricts(){
        districtRepository.findAll();
        List<ProvinceDistrictDto> dts = new ArrayList<>();
        for (District d : districtRepository.findAll()) {
            ProvinceDistrictDto dt = new ProvinceDistrictDto(
                    d.getDistrictId(), 
                    d.getProvince().getProvinceId(), 
                    d.getKotakab(), 
                    d.getDistrictName());
            dts.add(dt);
        }
        return dts;
    }

    public void saveDistricts(District district) {
        districtRepository.save(district);
    }

//    public District addDistrict(District district) {
//        return districtRepository.save(district);
//    }

//    public District getDistrictById(Integer id) {
//        District district = districtRepository.findById(id).get();
//        if(district == null){
//            throw new RuntimeException(" Province not found for id :: " + id);
//        }
//        return district;
//    }

    public void deleteDistrictById(Integer id) {
        districtRepository.deleteById(id);
    }
}
