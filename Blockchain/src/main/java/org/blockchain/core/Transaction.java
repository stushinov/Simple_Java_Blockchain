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
        byte[] hashedTransaction = StringUtils.calcSHA256(this.sender + this.receiver + this.amount.toString());
        return Hex.toHexString(hashedTransaction);
    }
}
