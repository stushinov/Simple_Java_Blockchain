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
    private Set<String> peers;

    @Autowired
    public Node(Environment environment) {
        this.environment = environment;
        this.initId();
        this.setNodeAddress(this.environment);
        this.peers = new HashSet<>();
    }

    public void addPeer(String peer) {
        if(this.nodeAddress.equals(peer)){
            System.out.println("A node cannot contain itself.");
            return;
        }
        this.peers.add(peer);
    }

    public void removePeer(String peer) {
        if(this.peers.contains(peer)){
            this.peers.remove(peer);
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

    public Set<String> getPeers() {
        return this.peers;
    }
}
