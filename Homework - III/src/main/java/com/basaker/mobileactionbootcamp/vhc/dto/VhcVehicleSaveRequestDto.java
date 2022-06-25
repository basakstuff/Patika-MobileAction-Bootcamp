package com.basaker.mobileactionbootcamp.vhc.dto;

import lombok.Data;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Data
public class VhcVehicleSaveRequestDto {

    private Long usrUserId;
    private String model;
    private String brand;
    private String plate;
}
