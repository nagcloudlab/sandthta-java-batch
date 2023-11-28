package com.example.api.dto;

import lombok.Data;

@Data
public class TransferResponse {
    private Long txnId;
    private String statusMessage;
}
