package org.blockchain.web.models.binding;

import java.math.BigInteger;

public class TransactionBindingModel {

    private String sender;
    private String receiver;
    private BigInteger amount;

    public TransactionBindingModel() { }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
