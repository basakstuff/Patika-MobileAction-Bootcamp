package com.basaker.mobileactionbootcamp.gen.exceptions;

import com.basaker.mobileactionbootcamp.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends GenBusinessException{

    public ItemNotFoundException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
