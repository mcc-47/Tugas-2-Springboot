/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

/**
 *
 * @author ASUS
 */
public class ProvinceDistrictDto {
    private int districtId;
    private String districtName;
    private String kotakab; 
    private int provinceId;

    public ProvinceDistrictDto() {
    }

    public ProvinceDistrictDto(int districtId, int provinceId, String kotakab, String districtName) {
        this.districtId = districtId;
        this.provinceId = provinceId;
        this.kotakab = kotakab;
        this.districtName = districtName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public String getKotakab() {
        return kotakab;
    }

    public String getDistrictName() {
        return districtName;
    }
    
}
