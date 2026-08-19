package com.mc.mc_common.util;

import com.mc.mc_common.dto.ApiResponse;
import com.mc.mc_common.enums.ResponseStatus;
import java.time.Instant;

public class ResponseBuilder {

    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .timestamp(Instant.now())
                .status(ResponseStatus.SUCCESS)
                .message(message)
                .data(data)
                .build();
    }
}