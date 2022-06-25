package com.basaker.mobileactionbootcamp.gen.exceptions;

import com.basaker.mobileactionbootcamp.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author basak
 * @Date 16.06.2022
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException extends GenBusinessException {

    public DuplicateException (BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }

}
