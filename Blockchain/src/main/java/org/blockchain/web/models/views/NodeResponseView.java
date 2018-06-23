package org.blockchain.web.models.views;

public class NodeResponseView {

    private String nodeAddress;
    private boolean responded;

    public NodeResponseView(String nodeAddress, boolean responded) {
        this.nodeAddress = nodeAddress;
        this.responded = responded;
    }

    public String getNodeAddress() {
        return nodeAddress;
    }

    public void setNodeAddress(String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    public boolean isResponded() {
        return responded;
    }

    public void setResponded(boolean responded) {
        this.responded = responded;
    }
}
