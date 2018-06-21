package org.blockchain.core;

import org.blockchain.core.util.StringUtils;
import org.bouncycastle.util.encoders.Hex;


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


    public long proofOfWork(long lastProof){
        long newProof = 0;

        while(validProof(lastProof, newProof) != true){
            newProof++;
        }

        return newProof;
    }

    private boolean validProof(long lastProof, long newProof) {
        String guess = String.format("%s%s", lastProof, newProof);
        byte[] hashedGuessBytes = StringUtils.calcSHA256(guess);
        String hashedGuess = Hex.toHexString(hashedGuessBytes);

        return hashedGuess.substring(0, 5).equals("0000");
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
        this.blocks.add(newBlock);
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

    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public void setPendingTransactions(List<Transaction> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
