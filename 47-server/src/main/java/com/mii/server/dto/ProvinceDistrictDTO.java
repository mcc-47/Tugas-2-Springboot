
package com.mii.server.dto;


public class ProvinceDistrictDTO {

    private String districtName;
    private String provinceName;

    public ProvinceDistrictDTO() {

    }

    public ProvinceDistrictDTO(String districtName, String provinceName) {
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

}
