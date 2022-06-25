package com.basaker.mobileactionbootcamp.vhc.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Data
@RequiredArgsConstructor
public class VhcVehicleDetails {

    private final String userName;
    private final String userSurname;
    private final String model;
    private final String plate;
    private final String brand;
}
