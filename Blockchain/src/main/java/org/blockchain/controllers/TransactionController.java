package org.blockchain.controllers;

import org.blockchain.core.Blockchain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final Blockchain blockchain;

    @Autowired
    public TransactionController(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @PostMapping("/transaction/new")
    public String createTransaction(){
        return "something";
    }
}
