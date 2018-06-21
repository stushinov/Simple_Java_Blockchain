package org.blockchain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.blockchain.util.StringUtils;
import org.bouncycastle.util.encoders.Hex;

import java.util.ArrayList;
import java.util.List;

public class Block {

    private long index;

    private String previousBlockHash;

    private Long timestamp;

    private List<Transaction> transactions;

    private Long proof;

    public Block(long index, String previousBlockHash, Long timestamp, Long proof) {
        this.index = index;
        this.previousBlockHash = previousBlockHash;
        this.timestamp = timestamp;
        this.transactions = new ArrayList<>();
        this.proof = proof;
    }


    public String getPreviousBlockHash() {
        return this.previousBlockHash;
    }

    @JsonIgnore
    public String getBlockHash() {
        String blockJson = StringUtils.toJson(this);
        byte[] hashedBlock = StringUtils.calcSHA256(blockJson);
        return Hex.toHexString(hashedBlock);
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = new ArrayList<>(transactions);
    }

    public long getIndex() {
        return this.index;
    }

    public void setIndex(long index) {
        this.index = index;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Long getProof() {
        return proof;
    }

    public void setProof(Long proof) {
        this.proof = proof;
    }
}
