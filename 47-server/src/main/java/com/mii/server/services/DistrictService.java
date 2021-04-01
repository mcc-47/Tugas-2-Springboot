/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;
import com.mii.server.dto.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fadel M Nasution
 */
@Service
public class DistrictService {
    
    @Autowired
    public DistrictRepository districtRepository;
    
    //READ
    public List<ProvinceDistrictDTO> getDistrictAll() {
        //ambil list dari district
        List<Districts> districts = districtRepository.findAll();
        
        //Membuat list untuk nama provinsi dan nama district
        List<ProvinceDistrictDTO> pds = new ArrayList<>();
        
        //Ambil satu per satu
        for (Districts d : districts) {
            //Province District DTO -> name dari district
            ProvinceDistrictDTO pd = new ProvinceDistrictDTO(
                    d.getDistrictId(),
                    d.getKotakab(),
                    d.getDistrictName(),
                    d.getProvinceId().getProvinceName()
            );
            pds.add(pd);
        }
        return pds;
    }
}