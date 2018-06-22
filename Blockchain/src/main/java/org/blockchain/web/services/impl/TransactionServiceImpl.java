package org.blockchain.web.services.impl;

import org.blockchain.core.Blockchain;
import org.blockchain.core.Transaction;
import org.blockchain.web.models.binding.TransactionBindingModel;
import org.blockchain.web.models.views.BlockchainTransactionView;
import org.blockchain.web.models.views.TransactionSuccessView;
import org.blockchain.web.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final Blockchain blockchain;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionServiceImpl(Blockchain blockchain, ModelMapper modelMapper) {
        this.blockchain = blockchain;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionSuccessView createTransaction(TransactionBindingModel requestModel) {
        final String TRANSACTION_SENDER = requestModel.getSender();
        final String TRANSACTION_RECEIVER = requestModel.getReceiver();
        final BigInteger AMOUNT = requestModel.getAmount();
        final String SUCCESS_MESSAGE = "Transaction added successfully!";

        Transaction transaction = this.blockchain.newTransaction(TRANSACTION_SENDER, TRANSACTION_RECEIVER, AMOUNT);

        BlockchainTransactionView transactionView = this.modelMapper.map(transaction, BlockchainTransactionView.class);

        TransactionSuccessView successView = new TransactionSuccessView(SUCCESS_MESSAGE, transactionView);

        return successView;
    }
}
