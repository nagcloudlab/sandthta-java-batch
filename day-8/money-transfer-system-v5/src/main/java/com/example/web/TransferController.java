package com.example.web;

import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import com.example.service.TransferStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Component
@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/transfer")
    public String showTransferForm() {
        return "transfer-form";
    }

    @PostMapping("/transfer")
    public String doTransfer(
            @RequestParam double amount,
            @RequestParam String sourceAccNumber,
            @RequestParam String destAccNumber,
            Model model
    ) {
        TransferStatus transferStatus = transferService.transfer(amount, sourceAccNumber, destAccNumber);
        model.addAttribute("transferStatus", transferStatus);
        return "transfer-status";
    }


    @ExceptionHandler({AccountNotFoundException.class, AccountBalanceException.class})
    public String handleException(Exception ex, Model model) {
        model.addAttribute("exception", ex);
        return "transfer-status";
    }


}
