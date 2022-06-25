package com.basaker.mobileactionhw2.service.entityservice;

import com.basaker.mobileactionhw2.dao.CityDao;
import com.basaker.mobileactionhw2.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Service
@RequiredArgsConstructor
public class CityEntityService {

    private final CityDao cityDao;

    public City save(City city) {
        return cityDao.save(city);
    }

    public City findByPlateCode(String plateCode) {
        return cityDao.findByPlateCode(plateCode);
    }
}
