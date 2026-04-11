package com.mc.mc_common.exception;

import com.mc.mc_common.dto.ErrorResponse;
import com.mc.mc_common.dto.ValidationError;
import com.mc.mc_common.enums.ErrorCode;
import com.mc.mc_common.enums.ResponseStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(
            BaseException ex,
            HttpServletRequest request) {

        log.warn("Business Exception | code={} | message={} | path={}",
                ex.getErrorCode().getCode(),
                ex.getMessage(),
                request.getRequestURI());

        ErrorResponse response = ErrorResponse.builder()
                .status(ResponseStatus.ERROR)
                .errorCode(ex.getErrorCode().getCode()) // ✅ FIXED (no breaking)
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<ValidationError> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> ValidationError.builder()
                        .field(field.getField())
                        .message(field.getDefaultMessage())
                        .build())
                .toList();

        ErrorResponse response = ErrorResponse.builder()
                .status(ResponseStatus.ERROR)
                .errorCode(ErrorCode.VALIDATION_FAILED.getCode()) // ✅ FIXED
                .message(ErrorCode.VALIDATION_FAILED.getDefaultMessage())
                .errors(errors)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(ErrorCode.VALIDATION_FAILED.getHttpStatus()).body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraint(
            ConstraintViolationException ex,
            HttpServletRequest request) {

        List<ValidationError> errors = ex.getConstraintViolations()
                .stream()
                .map(this::mapConstraintViolation)
                .toList();

        ErrorResponse response = ErrorResponse.builder()
                .status(ResponseStatus.ERROR)
                .errorCode(ErrorCode.VALIDATION_FAILED.getCode()) // ✅ FIXED
                .message(ErrorCode.VALIDATION_FAILED.getDefaultMessage())
                .errors(errors)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(ErrorCode.VALIDATION_FAILED.getHttpStatus()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex,
            HttpServletRequest request) {

        log.error("Unhandled Exception | path={}", request.getRequestURI(), ex);

        ErrorResponse response = ErrorResponse.builder()
                .status(ResponseStatus.ERROR)
                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode()) // ✅ FIXED
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getDefaultMessage())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus()).body(response);
    }

    private ValidationError mapConstraintViolation(ConstraintViolation<?> violation) {
        return ValidationError.builder()
                .field(violation.getPropertyPath().toString())
                .message(violation.getMessage())
                .build();
    }
}