/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

import com.mii.server.entities.Provinces;

/**
 *
 * @author User
 */
public class DistrictProvinceDto {

    private String nameDistrict;
    private String provinceName;

    public DistrictProvinceDto(String nameDistrict, String provinceName) {

        this.nameDistrict = nameDistrict;
        this.provinceName = provinceName;
    }

    public DistrictProvinceDto() {

    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public String getProvinceName() {
        return provinceName;
    }

}
