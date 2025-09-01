package com.ekibiina.ekibiina.exceptions.handler;

import com.ekibiina.ekibiina.exceptions.BusinessException;
import com.google.firebase.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {

        var response =
                new ErrorResponse(
                        e.getCode(),
                        e.getDisplayMessage(),
                         e.getMessage());
        return ResponseEntity.status(400).body(response);
    }

    public record ErrorResponse(ErrorCode code, String displayMessage, String additionalInfo) {}
}
