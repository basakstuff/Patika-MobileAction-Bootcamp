package com.basaker.mobileactionhw2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author basak
 * @Date 7.06.2022
 */

@Entity
@Table(name = "COUNTRY")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(generator = "Country")
    @SequenceGenerator(name = "Country", sequenceName = "COUNTRY_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "CODE", length = 5, nullable = false, unique = true)
    private String code;

}
