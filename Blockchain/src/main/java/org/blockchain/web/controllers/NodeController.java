package org.blockchain.web.controllers;

import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.models.views.NodeResponseView;
import org.blockchain.web.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {

    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @PostMapping("/node/register")
    public NodeResponseView addNodeProcess(@RequestBody NodeRegisterBindingModel nodeRegisterBindingModel){
        NodeResponseView response = this.nodeService.registerNode(nodeRegisterBindingModel);
        return response;
    }

    @PostMapping("/node/update")
    public String updateNodeProcess(){
        return "unimplemented";
    }

    @GetMapping("/node")
    public NodeResponseView getNode(){
        NodeResponseView view = this.nodeService.getThisNode();
        return view;
    }

}
