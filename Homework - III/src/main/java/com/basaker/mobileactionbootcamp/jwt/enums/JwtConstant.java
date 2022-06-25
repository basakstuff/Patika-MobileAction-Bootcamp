package com.basaker.mobileactionbootcamp.jwt.enums;

/**
 * @author Basak Er
 * @since 1.0.0
 */
public enum JwtConstant {

    BEARER("Bearer ")
    ;

    private String constant;

    JwtConstant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return constant;
    }
}
