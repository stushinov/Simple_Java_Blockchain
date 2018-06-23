package org.blockchain.web.services.impl;

import org.blockchain.core.Block;
import org.blockchain.core.Blockchain;
import org.blockchain.web.models.views.BlockSuccessfullyMinedView;
import org.blockchain.web.models.views.BlockchainBlockView;
import org.blockchain.web.models.views.BlockchainView;
import org.blockchain.web.services.BlockchainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockchainServiceImpl implements BlockchainService{

    private final ModelMapper modelMapper;
    private final Blockchain blockchain;

    @Autowired
    public BlockchainServiceImpl(ModelMapper modelMapper, Blockchain blockchain) {
        this.modelMapper = modelMapper;
        this.blockchain = blockchain;
    }

    @Override
    public BlockchainView getBlockchainView() {
        BlockchainView blockchainView = this.modelMapper.map(this.blockchain, BlockchainView.class);
        return blockchainView;
    }

    @Override
    public BlockSuccessfullyMinedView mineBlock() {
        long previousNonce = this.blockchain.getLastBlock().getNonce();
        long newNonce = this.blockchain.proofOfWork(previousNonce);

        Block minedBlock = this.blockchain.newBlock(newNonce);

        BlockchainBlockView blockView = this.modelMapper.map(minedBlock, BlockchainBlockView.class);
        final String MINING_SUCCESS_MESSAGE = String.format("Successfully mined block: %s", minedBlock.getIndex());
        BlockSuccessfullyMinedView miningSuccess = new BlockSuccessfullyMinedView(MINING_SUCCESS_MESSAGE, blockView);

        return miningSuccess;
    }
}
