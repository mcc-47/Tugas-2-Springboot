/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.RegistDTO;
import com.mii.server.entities.Employee;

/**
 *
 * @author William Yangjaya
 */
public interface RegistService {
    public Employee insertData(RegistDTO registDTO);
}
