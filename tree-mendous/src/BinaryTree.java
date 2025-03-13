import java.util.List;
public interface BinaryTree {
    void insert(int value);
    boolean find(int value);
    void delete(int value);
    List<Integer> inOrderTraversal();
    List<Integer> preOrderTraversal();
    List<Integer> postOrderTraversal();
    int getHeight();
    int getDepth(int value);
    List<List<Integer>> levelOrderTraversal();
    void printAsciiTree();
}
