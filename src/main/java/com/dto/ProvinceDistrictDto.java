/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

/**
 *
 * @author jakab
 */
public class ProvinceDistrictDto {
    
    private Integer districtId;
    private String districtName;
    private String provinceName; //provinceId
    
    public ProvinceDistrictDto() {
    }

    public ProvinceDistrictDto(Integer districtId, String districtName, String provinceName) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
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
