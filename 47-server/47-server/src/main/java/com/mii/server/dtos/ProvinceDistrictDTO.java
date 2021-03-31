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
public class ProvinceDistrictDTO {

    private String kotaKab;
    private String districtName;
    private String provinceName;

    public String getKotaKab() {
        return kotaKab;
    }

    public void setKotaKab(String kotaKab) {
        this.kotaKab = kotaKab;
    }

    public ProvinceDistrictDTO(String kotaKab, String districtName, String provinceName) {
        this.kotaKab = kotaKab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public ProvinceDistrictDTO(String districtName, String provinceName) {
        this.districtName = districtName;
        this.provinceName = provinceName;
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
