package org.blockchain;

import org.blockchain.core.Block;
import org.blockchain.core.Blockchain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BlockchainTests {

    private Blockchain blockchain;

    @Before
    public void initBlockchain(){
        this.blockchain = new Blockchain();
    }

    @Test
    public void anIntilisedBlockChainShouldHaveTheGenesisBlockInsideIt() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        final long GENESIS_BLOCK_INDEX = 0;
        final Block PREVIOUS_BLOCK = getLastBlock(this.blockchain);
        final long INDEX_FOUND = PREVIOUS_BLOCK.getIndex();

        Assert.assertEquals("Missing genesis block!", GENESIS_BLOCK_INDEX, INDEX_FOUND);
    }


    @Test
    public void afterCreatingANewBlock_theNewBlockShouldHaveThePreviousBlocksIndexPlusOne() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final long INDEX_EXPECTED = 1;

        final long PROOF_MOCK = 4;

        this.blockchain.newBlock(PROOF_MOCK);

        final Block PREVIOUS_BLOCK = getLastBlock(this.blockchain);
        final long INDEX_FOUND = PREVIOUS_BLOCK.getIndex();

        Assert.assertEquals("Block index does not match!",INDEX_EXPECTED, INDEX_FOUND );
    }

    private Block getLastBlock(Blockchain blockchain) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = blockchain.getClass().getDeclaredMethod("getLastBlock");
        method.setAccessible(true);
        return (Block) method.invoke(blockchain, new Class[]{});
    }
}
