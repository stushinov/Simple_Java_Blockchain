package org.blockchain;

import org.blockchain.core.Blockchain;
import org.blockchain.util.RequestBuilder;
import org.blockchain.util.RequestBuilderImpl;
import com.google.gson.Gson;
import org.blockchain.util.StringUtils;
import org.blockchain.web.models.views.BlockchainView;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("server.port=8080")
public class RequestBuilderImplTests {

    private static final String CURRENT_SERVER_ADDRESS = "http://192.168.0.103:8080";

    @Autowired
    private RequestBuilder requestBuilder;

    @Autowired
    private Blockchain blockchain;


    @Test
    public void getRequestShouldReturnThePropperEntity(){
        //TODO: Finish the test
    }
}
