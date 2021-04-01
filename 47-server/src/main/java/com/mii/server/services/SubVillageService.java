
package com.mii.server.services;

import com.mii.server.dto.SubVillageDTO;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.SubVillageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class SubVillageService {
    @Autowired
    SubVillageRepository subVillageRepository;
    
    public List<SubVillageDTO> getAllSubVil() {
        List<SubVillageDTO> svd = new ArrayList<>();
        for (Villages v : subVillageRepository.findAll()) {
            SubVillageDTO sv = new SubVillageDTO (
            v.getVillageName(), v.getZipCode(), v.getSubdistrictId().getSubdistrictName());
            svd.add(sv);
        }
        return svd;
}
}

