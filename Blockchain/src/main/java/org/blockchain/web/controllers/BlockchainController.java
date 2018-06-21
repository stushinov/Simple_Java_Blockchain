package org.blockchain.web.controllers;

import org.blockchain.core.Blockchain;
import org.blockchain.web.models.views.BlockSuccessfullyMinedView;
import org.blockchain.web.models.views.BlockchainView;
import org.blockchain.web.services.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockchainController {

    private final BlockchainService blockchainService;

    @Autowired
    public BlockchainController(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }


    @GetMapping("/")
    public String index(){
        return "Hello world";
    }

    @GetMapping("/chain")
    public BlockchainView getBlockChain(){
        BlockchainView view = this.blockchainService.getBlockchainView();
        return view;
    }

    @GetMapping("/mine")
    public BlockSuccessfullyMinedView mineBlock(){
        BlockSuccessfullyMinedView successfullyMinedView = this.blockchainService.mineBlock();
        return successfullyMinedView;
    }
}
