package org.blockchain;

import org.blockchain.core.Node;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest("server.port=8080")
public class NodeTests {

    @Autowired
    private Node node;

    public NodeTests() {
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
}
