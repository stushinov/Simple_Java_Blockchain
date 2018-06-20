package org.blockchain.core;

import org.blockchain.core.util.StringUtils;
import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;

public class Transaction {

    private String transactionHash;
    private String sender;
    private String receiver;
    private BigInteger amount;

    public Transaction(String sender, String receiver, BigInteger amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.transactionHash = this.hashTransaction();
    }

    private String hashTransaction() {
        String transactionJson = StringUtils.toJson(this);
        byte[] hashedTransaction = StringUtils.calcSHA256(transactionJson);
        return Hex.toHexString(hashedTransaction);
    }
}
