package com.mc.mc_common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mc.mc_common.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @Builder.Default
    private Instant timestamp = Instant.now();

    private ResponseStatus status;
    private String errorCode;
    private String message;
    private String path;
    private List<ValidationError> errors;
}