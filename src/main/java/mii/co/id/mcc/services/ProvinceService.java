/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.services;

import  mii.co.id.mcc.entities.Provinces;
import java.util.List;
import mii.co.id.mcc.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class ProvinceService {
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    
    public List<Provinces> getAll() {
        return provinceRepository.findAll(); 
    }
    
}
