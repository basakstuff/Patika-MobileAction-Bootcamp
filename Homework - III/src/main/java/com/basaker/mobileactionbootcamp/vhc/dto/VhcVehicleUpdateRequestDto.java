package com.basaker.mobileactionbootcamp.vhc.dto;

import lombok.Data;

/**
 * @author basak
 * @Date 16.06.2022
 */
@Data
public class VhcVehicleUpdateRequestDto {
    private Long id;
    private Long usrUserId;
    private String brand;
    private String model;
    private String plate;
}
