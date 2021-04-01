
package com.mii.server.repositories;

import com.mii.server.entities.Districts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface DistrictRepository extends JpaRepository<Districts, Integer>{
    
}
