package util;

import com.google.gson.Gson;
import org.blockchain.core.Block;
import org.blockchain.core.Transaction;
import org.blockchain.util.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class StringUtilTests {

    private Block mockBlock;
    private List<Transaction> mockTransactions;

    @Before
    public void init() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.mockBlock = new Block(1, "0000",1l, 1l);

        this.mockTransactions = new ArrayList<>();
        seedTransactions(this.mockTransactions);

        Method m = this.mockBlock.getClass().getDeclaredMethod("setTransactions", List.class);
        m.setAccessible(true);

        m.invoke(this.mockBlock, mockTransactions);
    }


    @Test
    public void jsonReturnedFromStrinUtilsShouldBeTheSameWithTheOneReturnedFromGson(){
        Gson gson = new Gson();

        final String EXPECTED = gson.toJson(mockBlock);
        final String FOUND = StringUtils.toJson(mockBlock);

        Assert.assertEquals("JSON`s do not match!", EXPECTED, FOUND);
    }

    private void seedTransactions(List<Transaction> mockTransactions) {
        mockTransactions.add(new Transaction("1", "4", BigInteger.valueOf(20)));
        mockTransactions.add(new Transaction("2", "3", BigInteger.valueOf(20)));
        mockTransactions.add(new Transaction("3", "2", BigInteger.valueOf(20)));
        mockTransactions.add(new Transaction("4", "1", BigInteger.valueOf(20)));
    }
}
