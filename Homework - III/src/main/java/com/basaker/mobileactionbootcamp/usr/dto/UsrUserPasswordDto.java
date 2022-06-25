package com.basaker.mobileactionbootcamp.usr.dto;

import lombok.Data;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Data
public class UsrUserPasswordDto {

    private Long id;
    private String oldPassword;
    private String newPassword;
    private String newPasswordAgain;
}
