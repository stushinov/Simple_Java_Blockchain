package org.blockchain.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Component
public class Node {

    private Environment environment;
    private String nodeId;
    private String nodeAddress;
    private Map<String, Node> peers;

    @Autowired
    public Node(Environment environment) {
        this.environment = environment;
        this.initId();
        this.setNodeAddress(this.environment);
        this.peers = new HashMap<>();

    }

    public void addPeer(Node node) {
        this.peers.putIfAbsent(node.getNodeId(), node);
    }

    public void removePeer(Node node) {
        String nodeId = node.getNodeId();

        if (this.peers.containsKey(nodeId)) {
            this.peers.remove(nodeId);
        }
    }

    private void initId() {
        this.nodeId = UUID.randomUUID().toString();
    }

    private void setNodeAddress(Environment environment) {
        String serverPort = environment.getProperty("server.port");
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        this.nodeAddress = host + ":" + serverPort;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public String getNodeAddress() {
        return this.nodeAddress;
    }

    public Map<String, Node> getPeers() {
        return this.peers;
    }
}
