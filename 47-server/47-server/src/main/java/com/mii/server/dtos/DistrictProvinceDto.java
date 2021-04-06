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

    private Integer districtId;
    private String kab;
    private String districtName;
    private String provinceName;

    public DistrictProvinceDto(Integer districtId, String kab, String districtName , String provinceName) {
        this.districtId = districtId;
        this.kab = kab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

   

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    
}
