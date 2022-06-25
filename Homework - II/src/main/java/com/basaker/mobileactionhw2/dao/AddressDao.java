package com.basaker.mobileactionhw2.dao;

import com.basaker.mobileactionhw2.dto.AddressDetailDto;
import com.basaker.mobileactionhw2.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author basak
 * @Date 8.06.2022
 */
@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

    @Query(" select new com.basaker.mobileactionhw2.dto.AddressDetailDto( " +
            " coun.name, city.name " +
            " ) " +
            " from Address addr left join Country coun on addr.countryId = coun.id " +
            " left join City city on addr.cityId = city.id " +
            "where addr.id = :id "
    )
    AddressDetailDto findAddressDetails(@Param("id") Long id);
}
