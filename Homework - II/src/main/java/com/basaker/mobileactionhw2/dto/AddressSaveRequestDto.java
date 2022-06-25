package com.basaker.mobileactionhw2.dto;

import lombok.Data;

/**
 * @author basak
 * @Date 7.06.2022
 */
@Data
public class AddressSaveRequestDto {

    private Long countryId;
    private Long cityId;
    private Long districtId;
    private Long neighborhoodId;
    private Long streetId;
    private String doorNumber;
    private String apartmentNumber;
}
