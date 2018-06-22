package org.blockchain.web.controllers;

import org.blockchain.web.models.binding.NodeRegisterBindingModel;
import org.blockchain.web.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addNodeProcess(@RequestBody NodeRegisterBindingModel nodeRegisterBindingModel){
        this.nodeService.registerNode(nodeRegisterBindingModel);
        return "Node added";
    }

    @PostMapping("/node/update")
    public String updateNodeProcess(){
        return "astrw";
    }

}
