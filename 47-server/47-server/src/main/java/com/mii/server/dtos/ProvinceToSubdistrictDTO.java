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
public class ProvinceToSubdistrictDTO {
    private String subdistrictName;
    private String kotaKab;
    private String districtName;
    private String provinceName;

    public ProvinceToSubdistrictDTO(String subdistrictName, String kotaKab, String districtName, String provinceName) {
        this.subdistrictName = subdistrictName;
        this.kotaKab = kotaKab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }
    
    public ProvinceToSubdistrictDTO(String subdistrictName, String kotaKab, String districtName) {
        this.subdistrictName = subdistrictName;
        this.kotaKab = kotaKab;
        this.districtName = districtName;
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
