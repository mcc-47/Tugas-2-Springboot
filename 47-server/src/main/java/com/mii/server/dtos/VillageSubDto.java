/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

/**
 *
 * @author User
 */
public class VillageSubDto {
    private String subName;
    private String villageName;
    private String zipCode;

    public VillageSubDto() {
    }

    public VillageSubDto(String subName, String villageName, String zipCode) {
        this.subName = subName;
        this.villageName = villageName;
        this.zipCode = zipCode;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
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
    
    
}
