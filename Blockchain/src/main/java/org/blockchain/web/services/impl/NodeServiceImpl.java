package org.blockchain.web.services.impl;

import org.blockchain.core.Node;
import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {

    private final Node node;

    @Autowired
    public NodeServiceImpl(Node node) {
        this.node = node;
    }


    @Override
    public void registerNode(NodeRegisterBindingModel nodeRegisterBindingModel) {
    }
}
