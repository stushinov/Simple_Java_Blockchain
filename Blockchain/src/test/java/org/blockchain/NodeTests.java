package org.blockchain;

import org.blockchain.core.Node;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest("server.port=8080")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NodeTests {

    private static final String MOCK_ADDRESS = "192.168.0.103:1000";

    @Autowired
    private Node node;

    public NodeTests() { }

    @Test
    public void removingAnAddedPeerShouldRemoveItFromTheSet(){
        this.node.addPeer(MOCK_ADDRESS);
        this.node.removePeer(MOCK_ADDRESS);
        Assert.assertTrue("Peer not removed!",this.node.getPeers().size() == 0);
    }

    @Test
    public void addingANewNodeAddressShouldBeAppendedToPeersSet(){
        this.node.addPeer(MOCK_ADDRESS);
        Assert.assertTrue("Peer not added!",this.node.getPeers().size() == 1);
    }

    @Test
    public void creatingANewNodeShouldAssignTheProperAddressOfTheNode() throws NoSuchFieldException, IllegalAccessException, UnknownHostException {
        Field field = this.node.getClass().getDeclaredField("nodeAddress");
        field.setAccessible(true);

        String EXPECTED_HOST  = EXPECTED_HOST = InetAddress.getLocalHost().getHostAddress();
        final String EXPECTED_PORT = "8080";

        final String VALUE_EXPECTED = EXPECTED_HOST + ":"+ EXPECTED_PORT;
        final String VALUE_FOUND = (String) field.get(this.node);

        Assert.assertEquals("Field values do not match!", VALUE_EXPECTED, VALUE_FOUND);
    }

    private Environment initEnvirnomentMockWithPort(String port) {
        return new Environment() {
            @Override
            public String[] getActiveProfiles() {
                return new String[0];
            }

            @Override
            public String[] getDefaultProfiles() {
                return new String[0];
            }

            @Override
            public boolean acceptsProfiles(String... profiles) {
                return false;
            }

            @Override
            public boolean containsProperty(String key) {
                return false;
            }

            @Override
            public String getProperty(String key) {
                return port;
            }

            @Override
            public String getProperty(String key, String defaultValue) {
                return null;
            }

            @Override
            public <T> T getProperty(String key, Class<T> targetType) {
                return null;
            }

            @Override
            public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
                return null;
            }

            @Override
            public String getRequiredProperty(String key) throws IllegalStateException {
                return null;
            }

            @Override
            public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
                return null;
            }

            @Override
            public String resolvePlaceholders(String text) {
                return null;
            }

            @Override
            public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
                return null;
            }
        };
    }
}
