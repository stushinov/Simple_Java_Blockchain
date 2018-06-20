package org.blockchain.core;

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
}
