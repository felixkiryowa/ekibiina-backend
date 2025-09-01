package com.ekibiina.ekibiina.exceptions;

import com.google.firebase.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final ErrorCode code;
    private final String displayMessage;

    public BusinessException(
            ErrorCode code, String errorMessage, String displayMessage, Object... args) {
        super(errorMessage.formatted(args));
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public BusinessException(
            ErrorCode code,
            String errorMessage,
            String displayMessage,
            Throwable cause,
            Object... args) {
        super(errorMessage.formatted(args), cause);
        this.code = code;
        this.displayMessage = displayMessage;
    }
}
