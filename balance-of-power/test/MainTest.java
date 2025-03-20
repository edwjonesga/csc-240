import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class MainTest {
    private AVLTree avlTree;

    @BeforeEach
    void setUp() {
        avlTree = new AVLTree();
    }

    @Test
    void testInsertionAndBalancing() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30); // Should trigger an LL rotation

        List<List<Integer>> levelOrder = avlTree.levelOrderTraversal();
        assertEquals(Arrays.asList(Arrays.asList(20), Arrays.asList(10, 30)), levelOrder);
        assertEquals(1, avlTree.getHeight());
    }

    @Test
    void testInsertTriggeringLRRotation() {
        avlTree.insert(30);
        avlTree.insert(10);
        avlTree.insert(20); // Should trigger an LR rotation

        List<List<Integer>> levelOrder = avlTree.levelOrderTraversal();
        assertEquals(Arrays.asList(Arrays.asList(20), Arrays.asList(10, 30)), levelOrder);
        assertEquals(1, avlTree.getHeight());
    }

    @Test
    void testInsertTriggeringRLRotation() {
        avlTree.insert(10);
        avlTree.insert(30);
        avlTree.insert(20); // Should trigger an RL rotation

        List<List<Integer>> levelOrder = avlTree.levelOrderTraversal();
        assertEquals(Arrays.asList(Arrays.asList(20), Arrays.asList(10, 30)), levelOrder);
        assertEquals(1, avlTree.getHeight());
    }

    @Test
    void testInsertTriggeringRRRotation() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30); // Should trigger an RR rotation

        List<List<Integer>> levelOrder = avlTree.levelOrderTraversal();
        assertEquals(Arrays.asList(Arrays.asList(20), Arrays.asList(10, 30)), levelOrder);
        assertEquals(1, avlTree.getHeight());
    }

    @Test
    void testInOrderTraversalAfterRotations() {
        avlTree.insert(30);
        avlTree.insert(10);
        avlTree.insert(20); // Should trigger an LR rotation
        avlTree.insert(40);
        avlTree.insert(50); // Should balance properly
        
        List<Integer> inOrder = avlTree.inOrderTraversal();
        assertEquals(Arrays.asList(10, 20, 30, 40, 50), inOrder);
        List<List<Integer>> levelOrder = avlTree.levelOrderTraversal();
        assertEquals(Arrays.asList(Arrays.asList(20), Arrays.asList(10, 40), Arrays.asList(30, 50)), levelOrder);
      
        avlTree.insert(35); // Should balance properly
        List<List<Integer>> levelOrder = avlTree.levelOrderTraversal();
        assertEquals(Arrays.asList(Arrays.asList(30), Arrays.asList(10, 40), Arrays.asList(10, 35, 50)), levelOrder);
        assertEquals(2, avlTree.getHeight());
      
    }
}
