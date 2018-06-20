package org.blockchain.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {

    private List<Transaction> pendingTransactions;
    private List<Block> blocks;

    public Blockchain(){
        this.initBlocks();
        this.pendingTransactions = new ArrayList<>();
    }

    public void newTransaction(String sender, String receiver, BigInteger amount){
        this.pendingTransactions.add(new Transaction(sender, receiver, amount));
    }

    private void initBlocks(){
        this.blocks = new ArrayList<>();
        Block genesisBlock = new Block(0,"1", new Date().getTime(), 100L);
        this.blocks.add(genesisBlock);
    }
}
