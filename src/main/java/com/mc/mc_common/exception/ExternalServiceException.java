package com.mc.mc_common.exception;

import com.mc.mc_common.enums.ErrorCode;

public class ExternalServiceException extends BaseException {
    public ExternalServiceException(ErrorCode code) {
        super(code);
    }
}
