package com.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransferStatus {
    private long txnId;
    private String message;
}
