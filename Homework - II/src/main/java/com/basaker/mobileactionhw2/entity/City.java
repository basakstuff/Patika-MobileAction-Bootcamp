package com.basaker.mobileactionhw2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author basak
 * @Date 7.06.2022
 */

@Entity
@Table(name = "CITY")
@Getter
@Setter
public class City {

    @GeneratedValue(generator = "City")
    @SequenceGenerator(name = "City", sequenceName = "CITY_ID_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PLATE_CODE", length = 5, nullable = false)
    private String plateCode;

    @Column(name = "COUNTRY_ID")
    private Long countryId;
}
