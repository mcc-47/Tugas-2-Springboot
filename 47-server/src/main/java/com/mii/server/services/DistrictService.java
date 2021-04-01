package com.mii.server.services;

import com.mii.server.entities.Districts;
import com.mii.server.entities.Provinces;
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

    DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    //create
    public Districts insert(Districts district) {
        return districtRepository.save(district);
    }

    //Read
    public List<Districts> getAll() {
        List<Districts> dis = new ArrayList<>();
        for (Districts district : districtRepository.findAll()) {
            dis.add(new Districts(district.getDistrictId(), district.getDistrictName(), district.getKab(), district.getProvinceId()));
        }
        return dis;
    }

    //read by id 
    public Districts getById(Integer districtId) {
        Districts dis = districtRepository.findById(districtId).get();
        return dis;
    }

    //Update
    public void update(Integer districtId, String districtName, String kab, Integer provinceId) {
        Districts dis = districtRepository.getOne(districtId);
        dis.setDistrictId(districtId);
        dis.setDistrictName(districtName);
        dis.setKab(kab);
        dis.setProvinceId(provinceId);
        districtRepository.save(dis);
    }

    //delete
    public void delete(Integer districtId) {
        districtRepository.deleteById(districtId);
    }
    
}
