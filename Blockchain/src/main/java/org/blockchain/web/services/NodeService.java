package org.blockchain.web.services;

import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.models.views.NodeResponseView;
import org.blockchain.web.models.views.NodeDetailsView;

public interface NodeService {
    NodeResponseView registerNode(NodeRegisterBindingModel nodeRegisterBindingModel);

    NodeDetailsView getThisNode();
}
