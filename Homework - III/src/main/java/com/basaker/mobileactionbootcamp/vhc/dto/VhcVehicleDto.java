package com.basaker.mobileactionbootcamp.vhc.dto;

import lombok.Data;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Data
public class VhcVehicleDto {

    private Long id;
    private Long usrUserId;
    private String model;
    private String plate;
    private String brand;
}
