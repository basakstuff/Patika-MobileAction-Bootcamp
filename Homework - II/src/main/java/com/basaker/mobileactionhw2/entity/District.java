package com.basaker.mobileactionhw2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author basak
 * @Date 7.06.2022
 */

@Entity
@Table(name = "DISTRICT")
@Getter
@Setter
public class District {

    @Id
    @SequenceGenerator(name = "District", sequenceName = "DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "District")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "CITY_ID")
    private Long cityId;
}