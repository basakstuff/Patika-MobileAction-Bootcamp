package com.basaker.mobileactionbootcamp.jwt.dto;

import lombok.Data;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Data
public class JwtLoginRequestDto {

    private String username;
    private String password;
}
