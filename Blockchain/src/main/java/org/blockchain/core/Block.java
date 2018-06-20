package org.blockchain.core;

import org.blockchain.core.util.StringUtils;
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

    public long getIndex() {
        return this.index;
    }

    public String getPreviousBlockHash() {
        return this.previousBlockHash;
    }

    public String getBlockHash() {
        String blockJson = StringUtils.toJson(this);
        byte[] hashedBlock = StringUtils.calcSHA256(blockJson);
        return Hex.toHexString(hashedBlock);
    }

    protected void setTransactions(List<Transaction> transactions) {
        this.transactions = new ArrayList<>(transactions);
    }
}
