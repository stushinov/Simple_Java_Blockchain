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

    public void newBlock(long proof){
        Block previousBlock = this.getLastBlock();
        long blockIndex = previousBlock.getIndex() + 1;
        String previousBlockHash = previousBlock.getBlockHash();
        Block newBlock = new Block(blockIndex, previousBlockHash, new Date().getTime(), proof);
        newBlock.setTransactions(this.pendingTransactions);
        this.pendingTransactions.clear();
    }

    private Block getLastBlock(){
        return this.blocks.get(this.blocks.size()-1);
    }

    private void initBlocks(){
        this.blocks = new ArrayList<>();
        Block genesisBlock = new Block(0,"1", new Date().getTime(), 100L);
        this.blocks.add(genesisBlock);
    }
}
