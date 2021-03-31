/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceToSubdistrictDTO;
import com.mii.server.entities.Subdistrict;
import com.mii.server.repositories.SubdistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class SubdistrictServiceImpl implements SubdistrictService {

    @Autowired
    private SubdistrictRepository subdistrictRepository;

    public List<ProvinceToSubdistrictDTO> getProvinceToSubdistrict() {
        List<ProvinceToSubdistrictDTO> pdss = new ArrayList<>();
        for(Subdistrict s : subdistrictRepository.findAll()){
            ProvinceToSubdistrictDTO pds = new ProvinceToSubdistrictDTO(
                    s.getSubdistrictName(), s.getDistrictId().getKotakab(), s.getDistrictId().getDistrictName(),
                    s.getDistrictId().getProvinceId().getProvinceName()
            );
            pdss.add(pds);
        }
        return pdss;
    }
}
