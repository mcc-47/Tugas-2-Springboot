/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.District;
import java.util.List;

/**
 *
 * @author William Yangjaya
 */
public interface DistrictService {

    public List<ProvinceDistrictDTO> getProvinceDistrict();
    
    List<District> getAllDistricts();

    District getDistrictById(Integer id);

    District createDistrict(District district);

    District updateDistrictById(District district, Integer id);

    void deleteDistrictById(Integer id);

}
