package com.common.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private List<String> messages;
    private LocalDateTime timestamp;

    public ErrorResponse(int statusCode, List<String> messages) {
        this.statusCode = statusCode;
        this.messages = messages;
        this.timestamp = LocalDateTime.now();
    }
}
