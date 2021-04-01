/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Addresses;
import com.mii.server.repositories.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class AddressService {
    AddressRepository addressRepository;
    
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    
    //Create
    public boolean insertOne(Addresses address) {
        Addresses newAddresses = addressRepository.save(address);
        return addressRepository.existsById(newAddresses.getAddressId());
    }
    
    public void insertAll(List<Addresses> addressList) {
        addressRepository.saveAll(addressList);
    }
    
    //Read
    public List<Addresses> getAll() {
        return addressRepository.findAll();
    }
    
    public Addresses getOne(Integer id) {
        return addressRepository.findById(id).get();
    }
    
    //Update
    
    
    //Delete
}
