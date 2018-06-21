package org.blockchain.web.services.impl;

import org.blockchain.core.Blockchain;
import org.blockchain.web.models.binding.TransactionBindingModel;
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
        this.blockchain.newTransaction(TRANSACTION_SENDER, TRANSACTION_RECEIVER, AMOUNT);

        TransactionSuccessView successView = this.modelMapper.map(requestModel, TransactionSuccessView.class);
        successView.setMessage("Transaction added successfully!");

        return successView;
    }
}
