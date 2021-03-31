/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceToEmployeeDTO;
import java.util.List;

/**
 *
 * @author William Yangjaya
 */
public interface EmployeeService {
    public List<ProvinceToEmployeeDTO> getProvinceToEmployee();
}
