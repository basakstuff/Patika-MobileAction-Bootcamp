package com.basaker.mobileactionhw2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author basak
 * @Date 7.06.2022
 */

@Entity
@Table(name = "NEIGHBORHOOD")
@Getter
@Setter
public class Neighborhood {

    @Id
    @SequenceGenerator(name = "Neighborhood", sequenceName = "NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "Neighborhood")
    private Long id;

    @Column(name = "NAME", length = 150, nullable = false)
    private String name;

    @Column(name = "DISTRICT_ID")
    private Long districtId;
}
