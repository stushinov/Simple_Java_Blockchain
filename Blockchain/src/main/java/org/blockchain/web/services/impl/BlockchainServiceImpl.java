package org.blockchain.web.services.impl;

import org.blockchain.core.Blockchain;
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
}
