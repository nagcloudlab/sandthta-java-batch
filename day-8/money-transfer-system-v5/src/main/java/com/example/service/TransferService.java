package com.example.service;

public interface TransferService {
    TransferStatus transfer(double amount,String sourceAccNumber,String destAccNumber);
}
