package org.blockchain;

import org.blockchain.core.Block;
import org.blockchain.core.Blockchain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;

public class BlockchainTests {

    private Blockchain blockchain;

    @Before
    public void initBlockchain(){
        this.blockchain = new Blockchain();
    }

    @Test
    public void creationOfANewBlockShouldExtractThePendingTransactionsInsideIt() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        this.assertPendingTransactionsAreEmpty(this.blockchain);

        this.seedTransactions(this.blockchain);
        final long PROOF_MOCK = 4;
        this.blockchain.newBlock(PROOF_MOCK);
        Block block = getLastBlock(this.blockchain);

        this.assertPendingTransactionsAreEmpty(this.blockchain);

        final long TRANSACTIONS_EXPECTED = 4;
        final long TRANSACTIONS_FOUND = block.getTransactions().size();

        Assert.assertEquals("Transaction count mismatch!", TRANSACTIONS_EXPECTED, TRANSACTIONS_FOUND);
    }

    @Test
    public void callingNewTransactionMethodShouldAddTransactionToPendingTransactions(){

        this.assertPendingTransactionsAreEmpty(this.blockchain);

        this.seedTransactions(this.blockchain);

        final long EXPECTED_TRANSACTIONS_COUNT_AFTER_SEEDING = 4;
        final long ACTUAL_TRANSACTION_COUNT = this.blockchain.getPendingTransactions().size();

        Assert.assertEquals("Transactions count does not match!",
                EXPECTED_TRANSACTIONS_COUNT_AFTER_SEEDING,
                ACTUAL_TRANSACTION_COUNT);
    }

    private void assertPendingTransactionsAreEmpty(Blockchain blockchain) {
        //Check if pending transactions are empty.
        final long EXPECTED_BEGINNING_TRANSACTIONS_COUNT = 0;
        final long BEGINNING_TRANSACTIONS_COUNT = blockchain.getPendingTransactions().size();

        Assert.assertEquals("Transactions are not empty!",
                EXPECTED_BEGINNING_TRANSACTIONS_COUNT,
                BEGINNING_TRANSACTIONS_COUNT);
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

    private void seedTransactions(Blockchain blockchain) {
        blockchain.newTransaction("1", "4", BigInteger.valueOf(20));
        blockchain.newTransaction("2", "3", BigInteger.valueOf(20));
        blockchain.newTransaction("3", "2", BigInteger.valueOf(20));
        blockchain.newTransaction("4", "1", BigInteger.valueOf(20));
    }
}
