package com.basaker.mobileactionbootcamp.usr.exceptions;

import com.basaker.mobileactionbootcamp.gen.enums.BaseErrorMessage;

/**
 * @author basak
 * @Date 16.06.2022
 */
public enum UsrUserErrorMessage implements BaseErrorMessage {
    USER_NOT_FOUND("User not found"),
    USERNAME_ALREADY_EXIST("Username is already exist"),
    USERNAME_PASSWORD_DO_NOT_MATCH("Passwords don't match");

    private final String message;

    UsrUserErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
