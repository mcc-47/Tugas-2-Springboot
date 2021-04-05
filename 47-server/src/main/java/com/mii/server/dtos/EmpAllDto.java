/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

import java.util.Date;

/**
 *
 * @author User
 */
public class EmpAllDto {
    private String EmployeeName;
    private String gender;
    private String email;
    private Date birthdate;
    private String Street;
    private String VillageName;
    private String ZipCode;
    private String SubDistrictName;
    private String kab;
    private String DistrictName;
    private String provinceName;

    public EmpAllDto(String EmployeeName,String gender,String email,Date birthdate, String Street, String VillageName, String ZipCode, String SubDistrictName, String kab, String DistrictName, String provinceName) {
        this.EmployeeName = EmployeeName;
        this.gender = gender;
        this.email = email;
        this.birthdate = birthdate;
        this.Street = Street;
        this.VillageName = VillageName;
        this.ZipCode = ZipCode;
        this.SubDistrictName = SubDistrictName;
        this.kab = kab;
        this.DistrictName = DistrictName;
        this.provinceName = provinceName;
    }

    public EmpAllDto() {
    }

    public String getEmployeeName() {
        return EmployeeName;
    }
    
    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String VillageName) {
        this.VillageName = VillageName;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getSubDistrictName() {
        return SubDistrictName;
    }

    public void setSubDistrictName(String SubDistrictName) {
        this.SubDistrictName = SubDistrictName;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
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
