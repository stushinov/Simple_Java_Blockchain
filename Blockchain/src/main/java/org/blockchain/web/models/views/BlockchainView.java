package org.blockchain.web.models.views;

import java.util.List;

public class BlockchainView {

    private List<BlockchainTransactionView> pendingTransactions;
    private List<BlockchainBlockView> blocks;

    public BlockchainView() {
    }

    public List<BlockchainTransactionView> getPendingTransactions() {
        return pendingTransactions;
    }

    public void setPendingTransactions(List<BlockchainTransactionView> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public List<BlockchainBlockView> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlockchainBlockView> blocks) {
        this.blocks = blocks;
    }
}
