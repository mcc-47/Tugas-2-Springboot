/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

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
 * @author ASUS
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
    @Column(name = "privileges_id")
    private Integer privilegesId;
    @Basic(optional = false)
    @Column(name = "privilege")
    private String privilege;
    @JoinTable(name = "role_privilege", joinColumns = {
        @JoinColumn(name = "privileges_id", referencedColumnName = "privileges_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Roles> rolesCollection;

    public Privileges() {
    }

    public Privileges(Integer privilegesId) {
        this.privilegesId = privilegesId;
    }

    public Privileges(Integer privilegesId, String privilege) {
        this.privilegesId = privilegesId;
        this.privilege = privilege;
    }

    public Integer getPrivilegesId() {
        return privilegesId;
    }

    public void setPrivilegesId(Integer privilegesId) {
        this.privilegesId = privilegesId;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegesId != null ? privilegesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privileges)) {
            return false;
        }
        Privileges other = (Privileges) object;
        if ((this.privilegesId == null && other.privilegesId != null) || (this.privilegesId != null && !this.privilegesId.equals(other.privilegesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Privileges[ privilegesId=" + privilegesId + " ]";
    }
    
}
