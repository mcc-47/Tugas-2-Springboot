/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zahra
 */
@Entity
@Table(name = "privileges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privileges.findAll", query = "SELECT p FROM Privileges p")})
public class Privileges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "privilege_id")
    private Integer privilegeId;
    @Basic(optional = false)
    @Column(name = "privilege_name")
    private String privilegeName;
    @JoinTable(name = "role_privileges", joinColumns = {
        @JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Role> roleCollection;

    public Privileges() {
    }

    public Privileges(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public Privileges(Integer privilegeId, String privilegeName) {
        this.privilegeId = privilegeId;
        this.privilegeName = privilegeName;
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegeId != null ? privilegeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privileges)) {
            return false;
        }
        Privileges other = (Privileges) object;
        if ((this.privilegeId == null && other.privilegeId != null) || (this.privilegeId != null && !this.privilegeId.equals(other.privilegeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Privileges[ privilegeId=" + privilegeId + " ]";
    }
    
}
