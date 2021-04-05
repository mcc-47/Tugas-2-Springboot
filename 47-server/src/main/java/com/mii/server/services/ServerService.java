/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.repositories.ServerRepository;
import com.mii.server.entities.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@Service
public class ServerService {
    
    @Autowired
    ServerRepository serverRepository;
    
    @Autowired
    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }
    
    
    // Read
    public List<Provinces> getAll(){
        List<Provinces> provinces = new ArrayList<>();
        for (Provinces province:serverRepository.findAll()){
        provinces.add(new Provinces(province.getProvinceId(),province.getProvinceName()));
    }
        return provinces;
    }
    // Insert
    /*public List<Provinces> insertData() {
        List<Provinces> provinces = new ArrayList<>();
            provinces.add(new Provinces(20,"Wiliam "));
        return serverRepository.saveAll(provinces);
    }*/
    public Provinces insertData(Provinces provinces){
        return serverRepository.save(provinces);
    }
    // Update
    /*public void update(Integer id, String name){
        Provinces province = serverRepository.findById(id).get();
        province.setProvinceName(name);
        serverRepository.save(province);
    }*/
    /*public Provinces update(Integer id, String name){
         Provinces province = serverRepository.findById(id).get();
        province.setProvinceName(name);
        return serverRepository.save(province);
    }*/
    
    
    public boolean delete(Integer id){
        serverRepository.deleteById(id);
        return !serverRepository.existsById(id);
    }

    /*public Provinces update(Integer id, String name) {
        Provinces province = serverRepository.findById(id).get();
        province.setProvinceName(name);
        return serverRepository.save(province);
    }*/

    public void update(Integer id, Provinces provinces) {
        Provinces province = serverRepository.findById(id).get();
        province.setProvinceName(provinces.getProvinceName());
        serverRepository.save(province);
    }

    public Provinces getById(Integer id) {
        return serverRepository.getOne(id);
    }
}
