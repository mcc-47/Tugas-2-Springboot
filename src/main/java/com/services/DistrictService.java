/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dto.ProvinceDistrictDto;
import com.entities.Districts;
import com.entities.Provinces;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repositories.DistrictRepository;
import com.repositories.ProvinceRepository;

/**
 *
 * @author jakab
 */
@Service
public class DistrictService {
    
    @Autowired
    DistrictRepository districtRepository;
    
    @Autowired
    ProvinceRepository provinceRepository;

    public DistrictService() {
    }

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
    
    public List<ProvinceDistrictDto> listAll(){
        List<Districts> districts = districtRepository.findAll();
        List<ProvinceDistrictDto> pdds = new ArrayList<>();
        for (Districts district : districts) {
            ProvinceDistrictDto pdd = new ProvinceDistrictDto(
                    district.getDistrictId(),
                    district.getDistrictName(),
                    district.getProvinceId().getProvinceName()
            );
            pdds.add(pdd);
        }
        return pdds;
    }
    
    public Districts getById(Integer id){
        return districtRepository.findById(id).get();
    }
    
    public Districts insert(Districts district){
        if (!provinceRepository.existsById(district.getProvinceId().getProvinceId())) {
            Provinces newProvince = provinceRepository.save(district.getProvinceId());
            district.setProvinceId(newProvince);
        }
        return districtRepository.save(district);
    }
    
    public Districts update(Integer id, Districts district)throws Exception{
        if (!provinceRepository.existsById(district.getProvinceId().getProvinceId())){
            throw new Exception("District unfound");
        }
        Districts oldDistrict = districtRepository.getOne(id);
        oldDistrict.setKab(district.getKab());
        oldDistrict.setDistrictName(district.getDistrictName());
        oldDistrict.setProvinceId(district.getProvinceId());
        return districtRepository.save(oldDistrict);
    }
    
    public void delete(Integer id){
        districtRepository.deleteById(id);
    }
}
