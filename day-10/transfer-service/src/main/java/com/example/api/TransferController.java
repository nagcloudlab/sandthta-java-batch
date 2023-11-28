package com.example.api;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.HttpError;
import com.example.api.dto.TransferRequest;
import com.example.api.dto.TransferResponse;
import com.example.exception.NotEnoughBalanceException;
import com.example.exception.NotFoundException;
import com.example.service.TransferService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;


    @PostMapping(
        consumes = "application/json",
        produces = "application/json"
    )
    public TransferResponse doTransfer(@RequestBody TransferRequest request){
        transferService.transfer(request.getAmount(), request.getSource(), request.getDestination());
        TransferResponse transferResponse=new TransferResponse();
        transferResponse.setTxnId(new Random().nextLong());
        transferResponse.setStatusMessage("success");
        return transferResponse;
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpError handleNotFoundException(Exception ex,HttpServletRequest request){
        HttpError httpError=new HttpError();
        httpError.setStatus("404");
        httpError.setMessage(ex.getMessage());
        httpError.setTimestamp(LocalDateTime.now().toString());
        httpError.setPath(request.getRequestURI());
        return httpError;
    }

     @ExceptionHandler({NotEnoughBalanceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpError handleNotEnoughBalanceException(Exception ex,HttpServletRequest request){
        HttpError httpError=new HttpError();
        httpError.setStatus("400");
        httpError.setMessage(ex.getMessage());
        httpError.setTimestamp(LocalDateTime.now().toString());
        httpError.setPath(request.getRequestURI());
        return httpError;
    }
    
}
