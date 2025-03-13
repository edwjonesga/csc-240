import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
    }

    @Test
    void testInsertAndFind() {
        assertTrue(bst.find(10));
        assertTrue(bst.find(5));
        assertTrue(bst.find(15));
        assertFalse(bst.find(100));
    }

    @Test
    void testDelete() {
        assertTrue(bst.find(5));
        bst.delete(5);
        assertFalse(bst.find(5));
    }

    @Test
    void testTreeTraversals() {
        assertEquals(Arrays.asList(2, 5, 7, 10, 12, 15, 20), bst.inOrderTraversal());
        assertEquals(Arrays.asList(10, 5, 2, 7, 15, 12, 20), bst.preOrderTraversal());
        assertEquals(Arrays.asList(2, 7, 5, 12, 20, 15, 10), bst.postOrderTraversal());
    }

    @Test
    void testHeight() {
        assertEquals(2, bst.getHeight());
    }

    @Test
    void testDepth() {
        assertEquals(1, bst.getDepth(5));
        assertEquals(2, bst.getDepth(7));
    }

    @Test
    void testLevelOrderTraversal() {
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(10),
            Arrays.asList(5, 15),
            Arrays.asList(2, 7, 12, 20)
        );
        assertEquals(expected, bst.levelOrderTraversal());
    }
}
