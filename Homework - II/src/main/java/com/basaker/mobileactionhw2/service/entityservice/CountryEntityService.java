package com.basaker.mobileactionhw2.service.entityservice;

import com.basaker.mobileactionhw2.dao.CountryDao;
import com.basaker.mobileactionhw2.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Service
@RequiredArgsConstructor
public class CountryEntityService {

    private final CountryDao countryDao;

    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public Country save(Country country) {
        return countryDao.save(country);
    }

    public Country findByCountryCode(String countryCode) {
        return countryDao.findByCode(countryCode);
    }
}
