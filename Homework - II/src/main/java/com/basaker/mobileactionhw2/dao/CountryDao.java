package com.basaker.mobileactionhw2.dao;

import com.basaker.mobileactionhw2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Repository
public interface CountryDao extends JpaRepository<Country, Long> {

    Country findByCode(String code);

}
