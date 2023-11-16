package com.example.web;

import com.example.exeption.AccountBalanceException;
import com.example.exeption.AccountNotFoundException;
import com.example.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transfer")
    public String showTransferForm() {
        //....
        return "transfer-form";
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/transfer")
    public String doTransfer(
            @RequestParam String sourceAccNumber,
            @RequestParam String destAccNumber,
            @RequestParam double amount,
            Model model
    ) {
        transferService.transfer(amount, sourceAccNumber, destAccNumber);
        model.addAttribute("message", "Transfer-Successful");
        return "transfer-status";
    }

    @ExceptionHandler({AccountNotFoundException.class, AccountBalanceException.class})
    public String handleAccNotFoundException(Exception ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "transfer-status";
    }

}
