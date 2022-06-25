package com.basaker.mobileactionbootcamp.vhc.Exceptions;

import com.basaker.mobileactionbootcamp.gen.enums.BaseErrorMessage;

/**
 * @author basak
 * @Date 16.06.2022
 */
public enum VhcVehicleErrorMessage implements BaseErrorMessage {
    VEHICLE_NOT_EXIST("Vehicle not exist"),

    VEHICLE_ALREADY_EXIST("Vehicle is already exist"),
    VEHICLE_INVALID_PLATE("Plate cannot contain spaces, lowercase letters or Turkish characters.");

    private final String message;

    VhcVehicleErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}