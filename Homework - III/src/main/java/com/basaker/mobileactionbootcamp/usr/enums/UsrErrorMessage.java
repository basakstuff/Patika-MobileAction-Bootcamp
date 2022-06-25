package com.basaker.mobileactionbootcamp.usr.enums;

import com.basaker.mobileactionbootcamp.gen.enums.BaseErrorMessage;

/**
 * @author Basak Er
 * @since 1.0.0
 */
public enum UsrErrorMessage implements BaseErrorMessage {

    USER_DOES_NOT_EXIST("User does not exist!");

    private final String message;

    UsrErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
