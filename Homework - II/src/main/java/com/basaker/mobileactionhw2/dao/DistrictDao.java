package com.basaker.mobileactionhw2.dao;

import com.basaker.mobileactionhw2.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Repository
public interface DistrictDao extends JpaRepository<District, Long> {

    List<District> findAllByCityId(Long cityId);
}
