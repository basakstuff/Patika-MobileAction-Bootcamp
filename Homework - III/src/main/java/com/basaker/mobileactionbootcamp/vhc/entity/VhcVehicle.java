package com.basaker.mobileactionbootcamp.vhc.entity;

import com.basaker.mobileactionbootcamp.gen.entity.BaseEntity;
import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Entity
@Table(name = "VHC_VEHICLE")
@Getter
@Setter
public class VhcVehicle extends BaseEntity {

    @Id
    @GeneratedValue(generator = "VhcVehicle")
    @SequenceGenerator(name = "VhcVehicle", sequenceName = "VHC_VEHICLE_ID_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USR_USER")
    private UsrUser usrUser;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PLATE")
    private String plate;

    @Column(name = "BRAND")
    private String brand;
}
