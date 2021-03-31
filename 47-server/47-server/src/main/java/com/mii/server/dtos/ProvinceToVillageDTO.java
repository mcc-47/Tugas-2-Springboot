/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

/**
 *
 * @author William Yangjaya
 */
public class ProvinceToVillageDTO {
    private String villageName;
    private String zipCode;
    private String subdistrictName;
    private String kotaKab;
    private String districtName;
    private String provinceName;

    public ProvinceToVillageDTO(String villageName, String zipCode, String subdistrictName, String kotaKab, String districtName, String provinceName) {
        this.villageName = villageName;
        this.zipCode = zipCode;
        this.subdistrictName = subdistrictName;
        this.kotaKab = kotaKab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public String getKotaKab() {
        return kotaKab;
    }

    public void setKotaKab(String kotaKab) {
        this.kotaKab = kotaKab;
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
