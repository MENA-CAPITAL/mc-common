package com.mc.mc_common.dto;

import com.mc.mc_common.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    @Builder.Default
    private Instant timestamp = Instant.now();

    private ResponseStatus status;
    private String message;
    private T data;

    /*
     * Populated only for an ERROR response (mirrors ErrorResponse's
     * field so callers deserializing a downstream error as ApiResponse
     * - e.g. a Feign client typed for the success shape - can still
     * recover the machine-readable error code instead of just a
     * generic message).
     */
    private String errorCode;
}