package com.mii.server.services;

import com.mii.server.dto.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceDistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public List<ProvinceDistrictDTO> getAllDisProv() {
       List<ProvinceDistrictDTO> pds = new ArrayList<>();
        for (Districts d : districtRepository.findAll()) {
            ProvinceDistrictDTO ds = new ProvinceDistrictDTO(
                    d.getDistrictName(),
                    d.getProvinceId().getProvinceName());
            pds.add(ds);
        }
        return pds;
    }
}

