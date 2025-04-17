


import java.util.function.Function;

/**
 * A generic B-tree class that works with any implementation of BTreeNode,
 * including in-memory and persistent variants.
 */
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.function.Function;

public class Main {

    private static final int DEGREE = 3;
    private static final String FILENAME = "btree_test_data.bin";

    public static void main(String[] args) {
        System.out.println("=== In-Memory B-Tree Test ===");
        testInMemoryBTree();

        System.out.println("\n=== Persistent B-Tree Test ===");
        try {
            testPersistentBTree();
        } catch (IOException e) {
            System.err.println("Error during persistent B-tree test: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testInMemoryBTree() {
        Function<Boolean, IntegerBTreeNode> nodeCreator = isLeaf -> new IntegerBTreeNode(DEGREE, isLeaf);
        BTree<IntegerBTreeNode> tree = new BTree<>(DEGREE, nodeCreator);

        int[] values = {10, 20, 5, 6, 12};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("Traversal after insertions: " + tree.traverse());

        tree.remove(6);
        System.out.println("Traversal after removing 6: " + tree.traverse());
    }

    public static void testPersistentBTree() throws IOException {
        // Clean the file
        File file = new File(FILENAME);
        if (file.exists()) file.delete();

        Function<Boolean, PersistentIntegerBTreeNode> nodeCreator = isLeaf -> new PersistentIntegerBTreeNode(DEGREE, isLeaf);

        // Phase 1: Create and insert
        PersistentIntegerBTreeNode root1 = new PersistentIntegerBTreeNode(DEGREE, true);
        RandomAccessFile raf1 = new RandomAccessFile(FILENAME, "rw");
        root1.setFile(raf1);
        root1.setOffset(0);
        root1.markDirty();
        root1.writeToDisk();

        BTree<PersistentIntegerBTreeNode> tree1 = new BTree<>(DEGREE, root1, nodeCreator);
        int[] values = {10, 20, 5, 6, 12};
        for (int val : values) {
            tree1.insert(val);
        }

        System.out.println("Traversal after insertions: " + tree1.traverse());
        root1.writeToDisk();
        raf1.close();

        // Phase 2: Reopen and read
        PersistentIntegerBTreeNode root2 = new PersistentIntegerBTreeNode(DEGREE, true);
        RandomAccessFile raf2 = new RandomAccessFile(FILENAME, "rw");
        root2.setFile(raf2);
        root2.readFromDisk(0);

        BTree<PersistentIntegerBTreeNode> tree2 = new BTree<>(DEGREE, root2, nodeCreator);
        System.out.println("Traversal after reopening: " + tree2.traverse());

        raf2.close();
    }
}

