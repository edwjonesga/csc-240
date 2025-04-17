
import java.util.function.Function;

public class BTree<T extends BTreeNode> {

    private T root;
    private final int t;
    private final Function<Boolean, T> nodeCreator; // Function to create new nodes

    /**
     * Create a new BTree with a given degree, root node, and a node creator function.
     * @param t the minimum degree
     * @param root the root node (in-memory or persistent)
     * @param nodeCreator a function that creates new nodes (given whether the node is a leaf)
     */
    public BTree(int t, T root, Function<Boolean, T> nodeCreator) {
        this.t = t;
        this.root = root;
        this.nodeCreator = nodeCreator;
    }

    /**
     * Create a new BTree with no root assigned yet.
     * You must set it later.
     * @param t the minimum degree
     * @param nodeCreator a function to create new nodes
     */
    public BTree(int t, Function<Boolean, T> nodeCreator) {
        this.t = t;
        this.root = null;
        this.nodeCreator = nodeCreator;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public boolean search(int value) {
        return root != null && root.search(value) != null;
    }

    public void insert(int value) {
        if (root == null) {
            throw new IllegalStateException("Root is not initialized.");
        }

        if (root.getNumValues() == 2 * t - 1) {
            // Root is full → must split and grow height
            T newRoot = nodeCreator.apply(false);
            newRoot.getChildren()[0] = root;
            newRoot.splitChild(0, root);
            int idx = (value < newRoot.getValueAt(0)) ? 0 : 1;
            newRoot.getChildren()[idx].insertNonFull(value);
            root = newRoot;
        } else {
            root.insertNonFull(value);
        }
    }

    public void remove(int value) {
        if (root == null) return;

        root.remove(value);

        if (root.getNumValues() == 0 && !root.isLeaf()) {
            root = (T) root.getChildren()[0];
        }
    }

    public String traverse() {
        return root == null ? "" : root.traverse();
    }
}
