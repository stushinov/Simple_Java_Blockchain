package org.blockchain.web.models.views;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BlockSuccessfullyMinedView {

    private String message;
    
    @JsonProperty(value = "block")
    private BlockchainBlockView blockchainBlockView;

    public BlockSuccessfullyMinedView(String message, BlockchainBlockView blockchainBlockView) {
        this.message = message;
        this.blockchainBlockView = blockchainBlockView;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BlockchainBlockView getBlockchainBlockView() {
        return blockchainBlockView;
    }

    public void setBlockchainBlockView(BlockchainBlockView blockchainBlockView) {
        this.blockchainBlockView = blockchainBlockView;
    }
}
