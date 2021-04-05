/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class DistrictService {
    DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
    
    //Create
    public boolean save(Districts district) {
        Districts saveDistrict = districtRepository.save(district);
        return districtRepository.existsById(saveDistrict.getDistrictId());
    }
    
    //Read
    public List<Districts> getAll() {
        return districtRepository.findAll();
    }
    
    //Read ProvinceNameDTO
    public List<ProvinceDistrictDTO> getProvinceDistrictName() {
        //ambil list dari district
        List<Districts> districts =  districtRepository.findAll();
        
        //Membuat list untuk nama Province dan nama District
        List<ProvinceDistrictDTO> pds = new ArrayList<>();
        
        //Mengambil data satu-persatu
        for(Districts d : districts) {
            //ProvinceDistrictDTO -> Nama District dan Nama Province
            ProvinceDistrictDTO pd = new ProvinceDistrictDTO(
                    //Memasukkan ke constructor ProvinceDistrictDTO
                    d.getDistrictName(),
                    //Relasi dengan province ProvinceId attr
                    d.getProvinceId().getProvinceName());
            pds.add(pd);
        }
        return pds;
    }
    
    //Read Single Data
    public Districts getByid(Integer id) {
        return districtRepository.getOne(id);
    }
    
    //Update
    public void updateDistrictName(Integer id, Districts district) {
        Districts dist = districtRepository.getOne(id);
        dist.setDistrictName(district.getDistrictName());
        dist.setKotakab(district.getKotakab());
        districtRepository.save(dist);
    }
    
    //Delete
    public boolean deleteDistrictById(Integer id) {
        districtRepository.deleteById(id);
        return !districtRepository.existsById(id);
    }
    
}
