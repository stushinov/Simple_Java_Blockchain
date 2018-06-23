package org.blockchain.web.services;

import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.models.views.NodeResponseView;

public interface NodeService {
    NodeResponseView registerNode(NodeRegisterBindingModel nodeRegisterBindingModel);

    NodeResponseView getThisNode();
}
