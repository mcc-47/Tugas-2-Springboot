/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "district_id")
    private Integer districtId;
    @Basic(optional = false)
    @Column(name = "kotakab")
    private String kotakab;
    @Basic(optional = false)
    @Column(name = "district_name")
    private String districtName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    @JsonBackReference
    private Collection<Subdistrict> subdistrictCollection;
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    @ManyToOne(optional = false)
    private Province provinceId;

    public District() {
    }

    public District(Integer districtId) {
        this.districtId = districtId;
    }

    public District(String districtName) {
        this.districtName = districtName;
    }

    public District(Integer districtId, String kotakab, String districtName, Province provinceId) {
        this.districtId = districtId;
        this.kotakab = kotakab;
        this.districtName = districtName;
        this.provinceId = provinceId;
    }

    

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getKotakab() {
        return kotakab;
    }

    public void setKotakab(String kotakab) {
        this.kotakab = kotakab;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @XmlTransient
    public Collection<Subdistrict> getSubdistrictCollection() {
        return subdistrictCollection;
    }

    public void setSubdistrictCollection(Collection<Subdistrict> subdistrictCollection) {
        this.subdistrictCollection = subdistrictCollection;
    }

    public Province getProvince() {
        return provinceId;
    }

    public void setProvinceId(Province provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.District[ districtId=" + districtId + " ]";
    }
    
}
