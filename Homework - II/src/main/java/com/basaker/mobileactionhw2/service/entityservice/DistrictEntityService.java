package com.basaker.mobileactionhw2.service.entityservice;

import com.basaker.mobileactionhw2.dao.DistrictDao;
import com.basaker.mobileactionhw2.entity.District;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Service
@RequiredArgsConstructor
public class DistrictEntityService {

    private final DistrictDao districtDao;

    public District save(District district) {
        return districtDao.save(district);
    }

    public List<District> findAllByCityId(Long cityId) {
        return districtDao.findAllByCityId(cityId);
    }
}
