package org.blockchain.web.services;

import org.blockchain.web.models.binding.NodeRegisterBindingModel;

public interface NodeService {
    void registerNode(NodeRegisterBindingModel nodeRegisterBindingModel);
}
