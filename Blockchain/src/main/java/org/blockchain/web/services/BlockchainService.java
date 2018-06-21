package org.blockchain.web.services;

import org.blockchain.web.models.views.BlockSuccessfullyMinedView;
import org.blockchain.web.models.views.BlockchainView;

public interface BlockchainService {

    BlockchainView getBlockchainView();

    BlockSuccessfullyMinedView mineBlock();
}
