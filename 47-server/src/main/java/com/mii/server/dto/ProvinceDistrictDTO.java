/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

/**
 *
 * @author Asus
 */
public class ProvinceDistrictDTO {
    private Integer districtId;
    private String districtName;
    private String provinceName;
    
    public ProvinceDistrictDTO(){
        
    }
    
    public ProvinceDistrictDTO (Integer districtId, String districtName, String provinceName){
        this.districtId = districtId;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }
}
