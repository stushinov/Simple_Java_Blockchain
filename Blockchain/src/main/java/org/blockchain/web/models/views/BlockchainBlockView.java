package org.blockchain.web.models.views;


import java.util.List;

public class BlockchainBlockView {

    private long index;

    private String previousBlockHash;

    private Long timestamp;

    private List<BlockchainTransactionView> transactions;

    private Long proof;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<BlockchainTransactionView> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BlockchainTransactionView> transactions) {
        this.transactions = transactions;
    }

    public Long getProof() {
        return proof;
    }

    public void setProof(Long proof) {
        this.proof = proof;
    }
}
