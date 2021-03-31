/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceToAddressDTO;
import com.mii.server.entities.Address;
import com.mii.server.entities.Village;
import com.mii.server.repositories.AddressRepository;
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
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<ProvinceToAddressDTO> getProvinceToAddress() {
        List<ProvinceToAddressDTO> pdsvas = new ArrayList<>();
        for (Address a : addressRepository.findAll()) {
            ProvinceToAddressDTO pdsva = new ProvinceToAddressDTO(
                    a.getStreet1(), a.getStreet2(),
                    a.getVillageId().getVillageName(), a.getVillageId().getZipCode(),
                    a.getVillageId().getSubdistrictId().getSubdistrictName(),
                    a.getVillageId().getSubdistrictId().getDistrictId().getKotakab(), a.getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    a.getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            );
            pdsvas.add(pdsva);
        }
        return pdsvas;
    }

}
