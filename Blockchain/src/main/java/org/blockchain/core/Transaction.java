package org.blockchain.core;

import java.math.BigInteger;

public class Transaction {

    private String transactionHash;
    private String sender;
    private String receiver;
    private BigInteger amount;

    public Transaction(String transactionHash, String sender, String receiver, BigInteger amount) {
        this.transactionHash = transactionHash;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }
}
