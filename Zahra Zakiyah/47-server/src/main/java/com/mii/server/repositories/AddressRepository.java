/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.repositories;

import com.mii.server.entities.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zahra
 */
@Repository
public interface AddressRepository extends JpaRepository<Addresses, Integer> {
    
}
