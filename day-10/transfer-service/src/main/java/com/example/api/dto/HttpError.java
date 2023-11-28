package com.example.api.dto;

import lombok.Data;

@Data
public class HttpError {
    private String status;
    private String message;
    private String path;
    private String timestamp;
}
