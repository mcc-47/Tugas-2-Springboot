
package com.mii.server.dto;

public class SubVillageDTO {
    private String subName;
    private String villageName;
    private String zipCode;
    
    public SubVillageDTO() {
        
    }
    
    public SubVillageDTO(String subName, String villageName, String zipCode) {
        this.subName = subName;
        this.villageName = villageName;
        this.zipCode = zipCode;
    }

    public String getSubName() {
        return subName;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getZipCode() {
        return zipCode;
    }
    
    
}
