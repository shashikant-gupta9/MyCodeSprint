import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

class Block {
    private String previousHash;
    private List<String> transactions;
    private String blockHash;
    private long timestamp;

    Block(String previousHash, List<String> transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.timestamp = System.currentTimeMillis();
        this.blockHash = calculateBlockHash();
    }

    private String calculateBlockHash() {
        String dataToHash = previousHash + Long.toString(timestamp) + transactions.toString();
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dataToHash.getBytes());

            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

class Blockchain {
    private List<Block> blockchain;

    Blockchain() {
        blockchain = new ArrayList<>();
        blockchain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        List<String> transactions = new ArrayList<>();
        return new Block("0", transactions);
    }

    public void addBlock(List<String> transactions) {
        Block previousBlock = blockchain.get(blockchain.size() - 1);
        String previousHash = previousBlock.getBlockHash();
        Block newBlock = new Block(previousHash, transactions);
        blockchain.add(newBlock);
    }

    public List<Block> getBlockchain() {
        return blockchain;
    }
}

public class SimpleBlockchain {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        List<String> block1Transactions = new ArrayList<>();
        block1Transactions.add("Alice sends 10 BTC to Bob");
        block1Transactions.add("Bob sends 5 BTC to Carol");

        blockchain.addBlock(block1Transactions);

        List<String> block2Transactions = new ArrayList<>();
        block2Transactions.add("Carol sends 3 BTC to Alice");

        blockchain.addBlock(block2Transactions);

        // Print the blockchain
        for (Block block : blockchain.getBlockchain()) {
            System.out.println("Block Hash: " + block.getBlockHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Transactions: " + block.getTransactions());
            System.out.println("-------------------------------------");
        }
    }
}
