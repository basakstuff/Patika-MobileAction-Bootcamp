package com.basaker.mobileactionhw2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author basak
 * @Date 7.06.2022
 */

@Entity
@Table(name = "STREET")
@Getter
@Setter
public class Street {

    @Id
    @SequenceGenerator(name = "Street", sequenceName = "STREET_ID_SEQ")
    @GeneratedValue(generator = "Street")
    private Long id;

    @Column(name = "NAME", length = 150, nullable = false)
    private String name;

    @Column(name = "NEIGHBORHOOD_ID")
    private Long neighborhoodId;
}
