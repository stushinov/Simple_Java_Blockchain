package org.blockchain.web.models.views;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionSuccessView {

    private String message;

    @JsonProperty(value = "transaction")
    private BlockchainTransactionView transactionView;

    public TransactionSuccessView(String message, BlockchainTransactionView transactionView) {
        this.message = message;
        this.transactionView = transactionView;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BlockchainTransactionView getTransactionView() {
        return transactionView;
    }

    public void setTransactionView(BlockchainTransactionView transactionView) {
        this.transactionView = transactionView;
    }
}
