package com.basaker.mobileactionbootcamp.vhc.dao;

import com.basaker.mobileactionbootcamp.vhc.entity.VhcVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Basak Er
 * @since 1.0.0
 */
public interface VhcVehicleDao extends JpaRepository<VhcVehicle, Long> {


    boolean existsByPlate(String plate);

}
