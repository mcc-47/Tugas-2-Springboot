/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Province;
import java.util.List;

/**
 *
 * @author William Yangjaya
 */
public interface ProvinceService {

    List<Province> getAllProvinces();

    Province getProvinceById(Integer id);

    Province createProvince(Province province);

    Province updateProvinceById(Province province, Integer id);

    void deleteProvinceById(Integer id);

}
