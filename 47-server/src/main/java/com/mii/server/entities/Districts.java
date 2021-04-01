/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Fadel M Nasution
 */
@Entity
@Table(name = "district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Districts.findAll", query = "SELECT d FROM Districts d")})
public class Districts implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId", fetch = FetchType.LAZY)
    private List<Subdistricts> subdistrictsList;
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Provinces provinceId;

    public Districts() {
    }

    public Districts(Integer districtId) {
        this.districtId = districtId;
    }

    public Districts(Integer districtId, String kotakab, String districtName) {
        this.districtId = districtId;
        this.kotakab = kotakab;
        this.districtName = districtName;
    }

    public Districts(int i, String kota, String bogor, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Subdistricts> getSubdistrictsList() {
        return subdistrictsList;
    }

    public void setSubdistrictsList(List<Subdistricts> subdistrictsList) {
        this.subdistrictsList = subdistrictsList;
    }

    public Provinces getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Provinces provinceId) {
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
        if (!(object instanceof Districts)) {
            return false;
        }
        Districts other = (Districts) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Districts[ districtId=" + districtId + " ]";
    }
    
}