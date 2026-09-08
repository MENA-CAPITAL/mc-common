package com.mc.mc_common.exception;

import com.mc.mc_common.dto.ErrorResponse;
import com.mc.mc_common.enums.ErrorCode;
import com.mc.mc_common.enums.ResponseStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

// Must outrank GlobalExceptionHandler's unordered catch-all, or its Exception handler wins first-match resolution
@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorResponse> handleNumberFormat(
            NumberFormatException ex,
            HttpServletRequest request) {

        log.warn("Invalid numeric request value | path={} | message={}",
                request.getRequestURI(), ex.getMessage());

        return buildResponse(
                "Invalid request: expected a numeric value",
                request
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {

        log.warn("Invalid request parameter type | path={} | parameter={} | value={}",
                request.getRequestURI(), ex.getName(), ex.getValue());

        return buildResponse(
                "Invalid value for parameter: " + ex.getName(),
                request
        );
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleMissingHeader(
            MissingRequestHeaderException ex,
            HttpServletRequest request) {

        log.warn("Missing required header | path={} | header={}",
                request.getRequestURI(), ex.getHeaderName());

        return buildResponse(
                "Missing required header: " + ex.getHeaderName(),
                request
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingParameter(
            MissingServletRequestParameterException ex,
            HttpServletRequest request) {

        log.warn("Missing required request parameter | path={} | parameter={}",
                request.getRequestURI(), ex.getParameterName());

        return buildResponse(
                "Missing required parameter: " + ex.getParameterName(),
                request
        );
    }

    private ResponseEntity<ErrorResponse> buildResponse(
            String message,
            HttpServletRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .status(ResponseStatus.ERROR)
                .errorCode(ErrorCode.INVALID_REQUEST.getCode())
                .message(message)
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.ok(response);
    }
}
