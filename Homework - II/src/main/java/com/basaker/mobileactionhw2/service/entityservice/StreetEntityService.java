package com.basaker.mobileactionhw2.service.entityservice;

import com.basaker.mobileactionhw2.dao.StreetDao;
import com.basaker.mobileactionhw2.entity.Street;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Service
@RequiredArgsConstructor
public class StreetEntityService {

    private final StreetDao streetDao;

    public Street save(Street street) {
        return streetDao.save(street);
    }

    public Street updateStreetName(Long id, String name) {
        Optional<Street> streetOptional = streetDao.findById(id);

        Street street;
        if (streetOptional.isPresent()) {
            street = streetOptional.get();
        } else {
            throw new NotFoundException("Street with id:"+ id +"not found");
        }

        street.setName(name);

        return streetDao.save(street);
    }

    public List<Street> findAllByNeighborhoodId(Long neighborhoodId) {
        return streetDao.findAllByNeighborhoodId(neighborhoodId);
    }
}
