/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

/**
 *
 * @author Zahra
 */
public class ProvDisDTO {
    
    private String provinceName;
    private String districtName;

    public ProvDisDTO() {
    }

    public ProvDisDTO(String provinceName, String districtName) {
        this.provinceName = provinceName;
        this.districtName = districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
    
    
}
