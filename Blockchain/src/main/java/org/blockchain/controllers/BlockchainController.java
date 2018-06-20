package org.blockchain.controllers;

import com.google.gson.Gson;
import org.blockchain.core.Blockchain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockchainController {

    private final Blockchain blockchain;
    private final Gson gson;

    @Autowired
    public BlockchainController(Blockchain blockchain, Gson gson) {
        this.blockchain = blockchain;
        this.gson = gson;
    }


    @GetMapping("/")
    public String index(){
        return "Hello world";
    }

    @GetMapping("/chain")
    public Blockchain getBlockChain(){
        return this.blockchain;
    }
}
