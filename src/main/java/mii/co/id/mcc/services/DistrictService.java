/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.services;

import java.util.List;
import mii.co.id.mcc.entities.Districts;
import mii.co.id.mcc.entities.Provinces;
import mii.co.id.mcc.repositories.DistrictRepository;
import mii.co.id.mcc.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class DistrictService {
    
    @Autowired
    DistrictRepository districtRepository;
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    //Create
    public Districts insert(Districts district) {
        if(!provinceRepository.existsById(district.getProvinceId().getProvinceId())) {
            district.setProvinceId(provinceRepository.save(district.getProvinceId()));
        }
        return districtRepository.save(district);
    }
    
    //Read
    public List<Districts> getAll() {
        return districtRepository.findAll();
    }
    
    public Districts getOne(Integer id) {
        return districtRepository.findById(id).get();
    }
    
    //Delete
    public boolean delete(Integer id) {
        districtRepository.deleteById(id);
        return !districtRepository.existsById(id);
    }
    
    //Update
//    public Districts updateDistrictName(Integer i, String kab, String name) {
//        Districts district = districtRepository.findById(i).get();
//        district.setKab(kab);
//        district.setDistrictName(name);
//        return districtRepository.save(district);
//    }
    
    public Districts updateDistrict(Integer districtId, String kab, String districtName, Provinces province){
        Districts district = districtRepository.findById(districtId).get();
        district.setKab(kab);
        district.setDistrictName(districtName);
        if(!provinceRepository.existsById(province.getProvinceId())) {
            district.setProvinceId(provinceRepository.save(province));
        } else {
            district.setProvinceId(province);         
        }
        return districtRepository.save(district);
    }
    
}
