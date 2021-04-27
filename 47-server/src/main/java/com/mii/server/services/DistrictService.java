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
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

//    public List<District> getAllDistricts() {
//        return districtRepository.findAll();
//    }
    //READ all data
    public List<ProvinceDistrictDto> getAll() {
        districtRepository.findAll();
        List<ProvinceDistrictDto> dts = new ArrayList<>();
        for (District d : districtRepository.findAll()) {
            ProvinceDistrictDto dt = new ProvinceDistrictDto(
                    d.getDistrictId(),
                    d.getProvince().getProvinceName(),
                    d.getKotakab(),
                    d.getDistrictName());
            dts.add(dt);
        }
        return dts;
    }
    
    public List<District> getAll1(){
        return districtRepository.findAll();
    }
    
    public District getById(Integer id) {
        return districtRepository.findById(id).get();
    }

    //CREATE
    public District saveDistricts(District district) {
        return districtRepository.save(district);
    }

    //UPDATE
    public void update(Integer id, District districts) {
        District district = districtRepository.findById(id).get();
        district.setDistrictName(districts.getDistrictName());
        district.setKotakab(districts.getKotakab());
        district.setProvinceId(districts.getProvince());
        districtRepository.save(district);
    }

    //DELETE
    public void deleteDistrictById(Integer id) {
        districtRepository.deleteById(id);
    }
}
