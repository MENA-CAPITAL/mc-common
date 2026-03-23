package com.mc.mc_common.dto;


import com.mc.mc_common.enums.ResponseStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp;
    private ResponseStatus status;
    private String errorCode;
    private String message;
    private Map<String, String> details;
    private String path;

}
