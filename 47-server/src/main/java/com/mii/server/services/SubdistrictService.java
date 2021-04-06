/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Subdistricts;
import com.mii.server.repositories.SubdistrictRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class SubdistrictService {
    SubdistrictRepository subdistrictRepository;
    
    @Autowired
    public SubdistrictService(SubdistrictRepository subdistrictRepository) {
        this.subdistrictRepository = subdistrictRepository;
    }
    
    //Create
     public boolean insertOne(Subdistricts subdistrict) {
        Subdistricts newSubdistrict = subdistrictRepository.save(subdistrict);        
        return subdistrictRepository.existsById(newSubdistrict.getSubdistrictId());
    }
    
    public void insertAll(List<Subdistricts> subdistrictList) {
        subdistrictRepository.saveAll(subdistrictList);
    }
    
    //Read
    public List<Subdistricts> getAll() {
        return subdistrictRepository.findAll();
    }
    
    public Subdistricts getOne(Integer id) {
        return subdistrictRepository.findById(id).get();
    }
    
    //Update
    
    
    //Delete
}
