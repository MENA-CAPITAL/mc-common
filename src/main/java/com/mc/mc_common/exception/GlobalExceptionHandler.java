package com.mc.mc_common.exception;

import com.mc.mc_common.dto.ErrorResponse;
import com.mc.mc_common.enums.ErrorCode;
import com.mc.mc_common.enums.ResponseStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Base Exception Handler
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(
            BaseException ex,
            HttpServletRequest request) {

        log.error("Business Exception: {}", ex.getMessage());

        HttpStatus status = mapStatus(ex);

        return buildResponse(ex.getErrorCode(), ex.getMessage(), request, null, status);
    }

    // Validation: @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return buildResponse(
                ErrorCode.VALIDATION_ERROR,
                "Validation failed",
                request,
                errors,
                HttpStatus.BAD_REQUEST
        );
    }

    // ConstraintViolation (query params etc.)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request) {

        return buildResponse(
                ErrorCode.VALIDATION_ERROR,
                ex.getMessage(),
                request,
                null,
                HttpStatus.BAD_REQUEST
        );
    }

    // Fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex,
            HttpServletRequest request) {

        log.error("Unhandled Exception", ex);

        return buildResponse(
                ErrorCode.INTERNAL_SERVER_ERROR,
                "Unexpected server error",
                request,
                null,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    // Helper
    private ResponseEntity<ErrorResponse> buildResponse(
            ErrorCode errorCode,
            String message,
            HttpServletRequest request,
            Map<String, String> details,
            HttpStatus status) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(ResponseStatus.ERROR)
                .errorCode(errorCode.getCode())
                .message(message)
                .details(details)
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, status);
    }

    // Map Exception → HTTP Status
    private HttpStatus mapStatus(BaseException ex) {

        if (ex instanceof BadRequestException) return HttpStatus.BAD_REQUEST;
        if (ex instanceof UnauthorizedException) return HttpStatus.UNAUTHORIZED;
        if (ex instanceof ForbiddenException) return HttpStatus.FORBIDDEN;
        if (ex instanceof NotFoundException) return HttpStatus.NOT_FOUND;
        if (ex instanceof ConflictException) return HttpStatus.CONFLICT;

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}