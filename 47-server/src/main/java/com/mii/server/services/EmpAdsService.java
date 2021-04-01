
package com.mii.server.services;

import com.mii.server.dto.EmpAdsDTO;
import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmpAdsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EmpAdsService {

    @Autowired
    EmpAdsRepository empAdsRepository;

    public List<EmpAdsDTO> getAllEmpAds() {
        List<EmpAdsDTO> ead = new ArrayList<>();
        for (Employees e : empAdsRepository.findAll()) {
            EmpAdsDTO es = new EmpAdsDTO(
                    e.getEmployeeName(), 
                    e.getAddressId().getStreet1(), 
                    e.getAddressId().getVillageId().getVillageName(),
                    e.getAddressId().getVillageId().getZipCode(),
                    e.getAddressId().getVillageId().getSubdistrictId().getSubdistrictName(),
                    e.getAddressId().getVillageId().getSubdistrictId().getDistrictId().getKab(),
                    e.getAddressId().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    e.getAddressId().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()                 
            );
            ead.add(es);
        }
        return ead;
    }
    
    
}

//e.getEmployeeName(), e.getAddressId().getStreet1(),
//                    e.getSubdistrictId().getSubdistrictName(), 
//                    e.getDistrictId().getKab(), e.getDistrictId().getDistrictName(), e.getProvinceId().getProvinceName()