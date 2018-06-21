package org.blockchain.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    public TransactionController() { }

    @PostMapping("/transaction/new")
    public String createTransaction(){
        return "something";
    }
}
