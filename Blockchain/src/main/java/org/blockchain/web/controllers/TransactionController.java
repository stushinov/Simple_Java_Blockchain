package org.blockchain.web.controllers;

import org.blockchain.web.models.binding.TransactionBindingModel;
import org.blockchain.web.models.views.TransactionSuccessView;
import org.blockchain.web.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction/new")
    public TransactionSuccessView createTransaction(@RequestBody TransactionBindingModel bindingModel){
        TransactionSuccessView successView = this.transactionService.createTransaction(bindingModel);
        return successView;
    }
}
