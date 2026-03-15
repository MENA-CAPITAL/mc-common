package com.mc.mc_common.util;

import com.mc.mc_common.dto.ApiResponse;

import java.time.LocalDateTime;

public class ResponseBuilder {

    public static <T> ApiResponse<T> success(String message, T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
