/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Date;

/**
 *
 * @author Fadel M Nasution
 */
public class DataEmployeeDTO {
    
    private String employeeName;
    private String street1;
    private String villageName;
    private String SubdistrictName;
    private String DistrictName;
    private String provinceName;

    public DataEmployeeDTO(String employeeName, String street1, String villageName, String SubdistrictName, String DistrictName, String provinceName) {
        this.employeeName = employeeName;
        this.street1 = street1;
        this.villageName = villageName;
        this.SubdistrictName = SubdistrictName;
        this.DistrictName = DistrictName;
        this.provinceName = provinceName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getSubdistrictName() {
        return SubdistrictName;
    }

    public void setSubdistrictName(String SubdistrictName) {
        this.SubdistrictName = SubdistrictName;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
   
    
}
