package com.backend.BIPC.Exception;

import com.backend.BIPC.form.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = GenericException.class)
    public ResponseEntity<ErrorMessage> genericException(GenericException ex) {
        ErrorMessage errorMessage= new ErrorMessage(HttpStatus.BAD_REQUEST,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
