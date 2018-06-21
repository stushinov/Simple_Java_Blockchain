package org.blockchain.web.services;

import org.blockchain.web.models.binding.TransactionBindingModel;
import org.blockchain.web.models.views.TransactionSuccessView;

public interface TransactionService {

    TransactionSuccessView createTransaction(TransactionBindingModel requestModel);
}
