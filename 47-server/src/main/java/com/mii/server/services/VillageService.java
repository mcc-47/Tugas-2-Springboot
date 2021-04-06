/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Villages;
import com.mii.server.repositories.VillageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class VillageService {
    VillageRepository villageRepository;
    
    @Autowired
    public VillageService(VillageRepository villageRepository) {
        this.villageRepository = villageRepository;
    }
    
    //Create
    public boolean insertOne(Villages village) {
        Villages newVillage = villageRepository.save(village);
        return villageRepository.existsById(newVillage.getVillageId());
    }
    
    public void insertAll(List<Villages> villageList) {
        villageRepository.saveAll(villageList);
    }
    
    //Read
    public List<Villages> getAll() {
        return villageRepository.findAll();
    }
    
    public Villages getOne(Integer id) {
        return villageRepository.findById(id).get();
    }
    
    //Update
    
    
    //Delete
    
    
}
