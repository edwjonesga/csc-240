import org.junit.jupiter.api.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static final int DEGREE = 3;
    private static final String FILENAME = "btree_test_data.bin";

    @BeforeEach
    public void cleanUpFile() {
        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testInMemoryBTree() {
        Function<Boolean, IntegerBTreeNode> nodeCreator = isLeaf -> new IntegerBTreeNode(DEGREE, isLeaf);
        BTree<IntegerBTreeNode> tree = new BTree<>(DEGREE, nodeCreator);

        int[] values = {10, 20, 5, 6, 12};
        for (int val : values) {
            tree.insert(val);
        }

        String traversal = tree.traverse();
        for (int val : values) {
            assertTrue(traversal.contains(String.valueOf(val)), "Traversal should contain: " + val);
        }

        tree.remove(6);
        assertFalse(tree.traverse().contains("6"), "Traversal should no longer contain: 6");
    }

    @Test
    public void testPersistentBTreePersistence() throws IOException {
        Function<Boolean, PersistentIntegerBTreeNode> nodeCreator = isLeaf -> new PersistentIntegerBTreeNode(DEGREE, isLeaf);

        // Phase 1: Create and insert values
        PersistentIntegerBTreeNode root1 = new PersistentIntegerBTreeNode(DEGREE, true);
        try (RandomAccessFile raf = new RandomAccessFile(FILENAME, "rw")) {
            root1.setFile(raf);
            root1.setOffset(0);
            root1.markDirty();
            root1.writeToDisk();

            BTree<PersistentIntegerBTreeNode> tree1 = new BTree<>(DEGREE, root1, nodeCreator);
            int[] values = {10, 20, 5, 6, 12};
            for (int val : values) {
                tree1.insert(val);
            }

            String traversal = tree1.traverse();
            for (int val : values) {
                assertTrue(traversal.contains(String.valueOf(val)), "Persistent tree should contain: " + val);
            }

            root1.writeToDisk();
        }

        // Phase 2: Reopen and confirm data
        PersistentIntegerBTreeNode root2 = new PersistentIntegerBTreeNode(DEGREE, true);
        try (RandomAccessFile raf = new RandomAccessFile(FILENAME, "rw")) {
            root2.setFile(raf);
            root2.readFromDisk(0);

            BTree<PersistentIntegerBTreeNode> tree2 = new BTree<>(DEGREE, root2, nodeCreator);
            String traversal = tree2.traverse();
            assertTrue(traversal.contains("10"), "Should contain 10 after reopening");
            assertTrue(traversal.contains("12"), "Should contain 12 after reopening");
        }
    }
}
