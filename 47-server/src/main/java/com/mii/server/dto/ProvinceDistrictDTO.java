/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

/**
 *
 * @author Fadel M Nasution
 */
public class ProvinceDistrictDTO {
    private Integer districtId;
    private String kotakab;
    private String DistrictName;
    private String ProvinceName;

    public ProvinceDistrictDTO(Integer districtId, String kotakab, String DistrictName, String ProvinceName) {
        this.districtId = districtId;
        this.kotakab = kotakab;
        this.DistrictName = DistrictName;
        this.ProvinceName = ProvinceName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getKotakab() {
        return kotakab;
    }

    public void setKotakab(String kotakab) {
        this.kotakab = kotakab;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String ProvinceName) {
        this.ProvinceName = ProvinceName;
    }

    
    
    
}
