package com.basaker.mobileactionhw2.dao;

import com.basaker.mobileactionhw2.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Repository
public interface CityDao extends JpaRepository<City, Long> {

    City findByPlateCode(String plateCode);
}
