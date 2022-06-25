package com.basaker.mobileactionbootcamp.usr.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Data
public class UsrUserSaveRequestDto {

    @NotNull
    private String name;
    private String surname;
    private String username;

    @Size(min = 9)
    private String password;
}
