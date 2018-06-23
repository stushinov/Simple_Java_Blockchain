package org.blockchain.web.services.impl;

import org.blockchain.core.Node;
import org.blockchain.util.RequestBuilder;
import org.blockchain.util.StringUtils;
import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.models.views.NodeResponseView;
import org.blockchain.web.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {

    private final Node node;
    private final RequestBuilder requestBuilder;

    @Autowired
    public NodeServiceImpl(Node node, RequestBuilder requestBuilder) {
        this.node = node;
        this.requestBuilder = requestBuilder;
    }


    @Override
    public NodeResponseView registerNode(NodeRegisterBindingModel nodeRegisterBindingModel) {

        final String peerAddress = nodeRegisterBindingModel.getNodeAddress();
        final String fullPeerAddress = "http://" + nodeRegisterBindingModel.getNodeAddress() + "/node";
        String response = null;
        try {
            response = this.requestBuilder.doGet(fullPeerAddress);
            this.node.addPeer(peerAddress);
        } catch (NullPointerException npe){ return new NodeResponseView(peerAddress, false); }

        return StringUtils.fromJson(response, NodeResponseView.class);
    }

    @Override
    public NodeResponseView getThisNode() {
        NodeResponseView thisNode = new NodeResponseView(this.node.getNodeAddress(), true);
        return thisNode;
    }
}
