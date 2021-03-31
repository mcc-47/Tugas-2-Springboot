/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.District;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<ProvinceDistrictDTO> getProvinceDistrict(){
        List<ProvinceDistrictDTO> pds = new ArrayList<>();
        for (District d : districtRepository.findAll()){
            ProvinceDistrictDTO pd = new ProvinceDistrictDTO(
            d.getKotakab(),d.getDistrictName(), d.getProvinceId().getProvinceName()
            );
            pds.add(pd);
        }
        return pds;
    }
    
    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public District getDistrictById(Integer id) {
        Optional<District> optional = districtRepository.findById(id);
        District district = null;
        if (optional.isPresent()) {
            district = optional.get();
        } else {
            throw new RuntimeException(" Province not found for id :: " + id);
        }
        return district;
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District updateDistrictById(District districtDetails, Integer id) {
        District district = this.getDistrictById(id);
        district.setDistrictId(district.getDistrictId());
        district.setDistrictName(districtDetails.getDistrictName());
        return districtRepository.save(district);
    }

    @Override
    public void deleteDistrictById(Integer id) {
        this.districtRepository.deleteById(id);
    }

}
