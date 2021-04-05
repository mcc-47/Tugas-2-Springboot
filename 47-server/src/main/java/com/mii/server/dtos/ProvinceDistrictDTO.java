/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

/**
 *
 * @author ROG
 */
public class ProvinceDistrictDTO {
    private String ProvinceName;
    private String DistritName;

    public ProvinceDistrictDTO(String ProvinceName, String DistritName) {
        this.ProvinceName = ProvinceName;
        this.DistritName = DistritName;
    }
    
    
    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String ProvinceName) {
        this.ProvinceName = ProvinceName;
    }

    public String getDistritName() {
        return DistritName;
    }

    public void setDistritName(String DistritName) {
        this.DistritName = DistritName;
    }
    
    
}
