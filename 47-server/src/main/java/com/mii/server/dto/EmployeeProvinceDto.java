/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class EmployeeProvinceDto {
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String email;
    private String street1;
    private String villageName;
    private String zipCode;
    private String subdistrictName;
    private String districtName;
    private String provinceName;

    public EmployeeProvinceDto() {
    }

    public EmployeeProvinceDto(String employeeName, Date birthDate, String gender, String email, String street1, String villageName, String zipCode, String subdistrictName, String districtName, String provinceName) {
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.street1 = street1;
        this.villageName = villageName;
        this.zipCode = zipCode;
        this.subdistrictName = subdistrictName;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getStreet1() {
        return street1;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }
    
}
