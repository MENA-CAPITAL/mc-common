package com.mc.mc_common.exception;

import com.mc.mc_common.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException {

    private final ErrorCode errorCode;
    private final HttpStatus status;

    protected BaseException(ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
        this.status = errorCode.getHttpStatus();
    }

    protected BaseException(ErrorCode errorCode, String message) {
        super(message != null && !message.isBlank() ? message : errorCode.getDefaultMessage());
        this.errorCode = errorCode;
        this.status = errorCode.getHttpStatus();
    }
}