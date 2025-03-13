import java.util.List;
import java.util.ArrayList;
public class BinarySearchTree implements BinaryTree {
    private TreeNode root;
    
    static class TreeNode {
        int val;
        TreeNode left, right;
         
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    @Override
    public void insert(int value) {
        // TODO: Implement insert method
    }
    
    @Override
    public boolean find(int value) {
        // TODO: Implement find method
        return false;
    }
    
    @Override
    public void delete(int value) {
        // TODO: Implement delete method
    }
    
    @Override
    public List<Integer> inOrderTraversal() {
        // TODO: Implement inOrderTraversal method
        return new ArrayList<>();
    }
    
    @Override
    public List<Integer> preOrderTraversal() {
        // TODO: Implement preOrderTraversal method
        return new ArrayList<>();
    }
    
    @Override
    public List<Integer> postOrderTraversal() {
        // TODO: Implement postOrderTraversal method
        return new ArrayList<>();
    }
    
    @Override
    public int getHeight() {
        // TODO: Implement getHeight method
        return 0;
    }
    
    @Override
    public int getDepth(int value) {
        // TODO: Implement getDepth method
        return 0;
    }
    
    @Override
    public List<List<Integer>> levelOrderTraversal() {
        // TODO: Implement levelOrderTraversal method
        return new ArrayList<>();
    }
    
    @Override
    public void printAsciiTree() {
        // TODO: Implement printAsciiTree method
    }
}
