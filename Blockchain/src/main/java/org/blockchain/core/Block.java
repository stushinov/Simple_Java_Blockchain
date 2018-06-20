package org.blockchain.core;

import java.util.List;

public class Block {

    private long index;

    private String previousBlockHash;

    private Long timestamp;

    private List<Transaction> transactions;

    private Long proof;

    public Block(long index, String previousBlockHash, Long timestamp, List<Transaction> transactions, Long proof) {
        this.index = index;
        this.previousBlockHash = previousBlockHash;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.proof = proof;
    }

    public Block() {
    }
}
