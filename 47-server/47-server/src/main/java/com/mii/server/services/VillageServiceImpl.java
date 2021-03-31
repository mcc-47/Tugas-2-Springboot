/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceToVillageDTO;
import com.mii.server.entities.Village;
import com.mii.server.repositories.VillageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    private VillageRepository villageRepository;

    public List<ProvinceToVillageDTO> getProvinceToVillage() {
        List<ProvinceToVillageDTO> pdsvs = new ArrayList<>();
        for (Village v : villageRepository.findAll()) {
            ProvinceToVillageDTO pdsv = new ProvinceToVillageDTO(
                    v.getVillageName(), v.getZipCode(),
                    v.getSubdistrictId().getSubdistrictName(),
                    v.getSubdistrictId().getDistrictId().getKotakab(), v.getSubdistrictId().getDistrictId().getDistrictName(),
                    v.getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            );
            pdsvs.add(pdsv);
        }
        return pdsvs;
    }
}
