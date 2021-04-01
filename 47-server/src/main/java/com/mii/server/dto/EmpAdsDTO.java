
package com.mii.server.dto;

public class EmpAdsDTO {
    private String EmployeeName;
    private String Street;
    private String VillageName;
    private String ZipCode;
    private String SubdistrictName;
    private String kab;
    private String DistrictName;
    private String provinceName;
   
    public EmpAdsDTO(String EmployeeName, String Street, String VillageName, String ZipCode, 
            String SubdistrictName, String kab, String DistrictName, String provinceName) {
        this.EmployeeName = EmployeeName;
        this.Street = Street;
        this.VillageName = VillageName;
        this.ZipCode = ZipCode;
        this.SubdistrictName = SubdistrictName;
        this.kab = kab;
        this.DistrictName = DistrictName;
        this.provinceName = provinceName;
    }

    public EmpAdsDTO() {
    }

    public EmpAdsDTO(String employeeName, String street1, String villageName, String subdistrictName, 
            String districtName, String provinceName) {
        
    }
    
   
    public String getEmployeeName() {
        return EmployeeName;
    }

    public String getStreet() {
        return Street;
    }

    public String getVillageName() {
        return VillageName;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getSubdistrictName() {
        return SubdistrictName;
    }

    public String getKab() {
        return kab;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public String getProvinceName() {
        return provinceName;
    }

   
    
    
    
}
