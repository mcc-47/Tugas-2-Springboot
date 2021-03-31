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
public class ProvinceToAddressDTO {
    private String street1;
    private String street2;
    private String villageName;
    private String zipCode;
    private String subdistrictName;
    private String kotaKab;
    private String districtName;
    private String provinceName;

    public ProvinceToAddressDTO(String street1, String street2, String villageName, String zipCode, String subdistrictName, String kotaKab, String districtName, String provinceName) {
        this.street1 = street1;
        this.street2 = street2;
        this.villageName = villageName;
        this.zipCode = zipCode;
        this.subdistrictName = subdistrictName;
        this.kotaKab = kotaKab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
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
