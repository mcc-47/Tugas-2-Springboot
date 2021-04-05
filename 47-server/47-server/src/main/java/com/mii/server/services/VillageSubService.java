/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.VillageSubDto;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.VillageSubRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class VillageSubService {
    @Autowired
    VillageSubRepository villageSubRepository;
    
    public List<VillageSubDto> getAll(){
        List<VillageSubDto> vs = new ArrayList<>();
        for(Villages v : villageSubRepository.findAll()){
            VillageSubDto vsd = new VillageSubDto(
            v.getVillageName(),v.getZipCode(),v.getSubdistrictId().getSubdistrictName()
            );
            
            vs.add(vsd);
        
    }
        return vs;
}
}