package com.common.utils.aspects;

import com.common.dtos.ErrorResponse;
import com.common.utils.exceptions.*;
import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorResponseAspect {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestExceptions(InvalidEndpointRequestException e) {
        return new ErrorResponse(400, Collections.singletonList(e.getMessage()));
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationExceptions(ConstraintViolationException e) {
        return new ErrorResponse(400, e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessageTemplate)
                .collect(Collectors.toList()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ErrorResponse(404, Collections.singletonList(e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleResourcePersistenceException(ResourcePersistenceException e) {
        return new ErrorResponse(409, Collections.singletonList(e.getMessage()));
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ErrorResponse handleAuthenticationException(AuthenticationException e) {
//        return new ErrorResponse(401, Collections.singletonList(e.getMessage()));
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ErrorResponse handleAuthorizationException(AuthorizationException e) {
//        return new ErrorResponse(403, Collections.singletonList(e.getMessage()));
//    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherExceptions(Throwable t) {
        return new ErrorResponse(500, Collections.singletonList("An internal server error occurred. Devs, please check logs."));
    }
}
