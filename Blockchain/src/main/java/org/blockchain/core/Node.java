package org.blockchain.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

@Component
public class Node {

    private Environment environment;

    private String nodeAddress;
    private Set<String> peers;

    @Autowired
    public Node(Environment environment) {
        this.environment = environment;
        this.setNodeAddress(this.environment);
        this.peers = new HashSet<>();
    }

    public void addPeer(String peer){
        this.peers.add(peer);
    }

    public void removePeer(String peer){
        this.peers.remove(peer);
    }

    private void setNodeAddress(Environment environment)  {
        String serverPort = environment.getProperty("server.port");
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        this.nodeAddress = host + ":" + serverPort;
    }
}
