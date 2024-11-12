package com.app.messages.infrastructure.entrypoint.rest;

import com.app.messages.domain.model.exception.MessageError;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerException {

    private MessageError messageError;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<MessageError> webExchangeBindException(WebExchangeBindException e) {
        UtilLogger.info(HandlerException.class, "Ha ocurrido un error: {}", e.getMessage());
        messageError = MessageError.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            UtilLogger.info(HandlerException.class, "Error en validacion de datos de entrada : {}, en el campo {}", errorMessage, fieldName);
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<MessageError>jpaSystemException(JpaSystemException e) {
        UtilLogger.info(HandlerException.class, "Ha ocurrido un error en capa de DB : {}", e.getMessage());
        messageError = MessageError.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(messageError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<MessageError>nullPointerException(JpaSystemException e) {
        UtilLogger.info(HandlerException.class, "Ha ocurrido un error : {}", e.getMessage());
        messageError = MessageError.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(messageError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageError>exception(Exception e) {
        UtilLogger.info(HandlerException.class, "Ha ocurrido un error : {}", e.getMessage());
        messageError = MessageError.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(messageError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
