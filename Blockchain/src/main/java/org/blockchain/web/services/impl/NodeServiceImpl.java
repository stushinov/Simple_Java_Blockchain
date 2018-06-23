package org.blockchain.web.services.impl;

import org.blockchain.core.Node;
import org.blockchain.util.RequestBuilder;
import org.blockchain.util.StringUtils;
import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.models.views.NodeResponseView;
import org.blockchain.web.models.views.NodeDetailsView;
import org.blockchain.web.services.NodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {

    private final Node node;
    private final ModelMapper mapper;
    private final RequestBuilder requestBuilder;

    @Autowired
    public NodeServiceImpl(Node node, ModelMapper mapper, RequestBuilder requestBuilder) {
        this.node = node;
        this.mapper = mapper;
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

        NodeDetailsView detailsRetrieved = StringUtils.fromJson(response, NodeDetailsView.class);

        return new NodeResponseView(detailsRetrieved.getNodeAddress(), true);
    }

    @Override
    public NodeDetailsView getThisNode() {
        NodeDetailsView thisNode = this.mapper.map(this.node, NodeDetailsView.class);
        return thisNode;
    }
}
