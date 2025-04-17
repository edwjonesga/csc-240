/**
 * A skeleton class for a B-tree node that stores integer values.
 * Students should fill in the logic for each method using the hints provided
 * in the BTreeNode interface.
 */
public class IntegerBTreeNode implements BTreeNode {

  private int t; // Minimum degree (defines range for number of values)
  private int[] values; // Array of values in the node
  private BTreeNode[] children; // Array of child pointers
  private int numValues; // Current number of values in the node
  private boolean isLeaf; // True if this is a leaf node

  /**
   * Constructor to initialize a B-tree node.
   * @param t the minimum degree
   * @param isLeaf true if the node is a leaf
   */
  public IntegerBTreeNode(int t, boolean isLeaf) {
      this.t = t;
      this.isLeaf = isLeaf;
      this.values = new int[2 * t - 1];
      this.children = new BTreeNode[2 * t];
      this.numValues = 0;
  }

  @Override
  public boolean isLeaf() {
      return isLeaf;
  }

  @Override
  public int getNumValues() {
      return numValues;
  }

  @Override
  public BTreeNode search(int value) {
      // TODO: Implement search logic
      return null;
  }

  @Override
  public void insertNonFull(int value) {
      // TODO: Implement insert logic for a non-full node
  }

  @Override
  public void splitChild(int index, BTreeNode fullChild) {
      // TODO: Implement splitting logic for a full child
  }

  @Override
  public String traverse() {
      // TODO: Implement in-order traversal
      return "";
  }

  @Override
  public void remove(int value) {
      // TODO: Implement B-tree deletion
  }

  @Override
  public int getPredecessor(int index) {
      // TODO: Implement retrieval of in-order predecessor
      return -1;
  }

  @Override
  public int getSuccessor(int index) {
      // TODO: Implement retrieval of in-order successor
      return -1;
  }

  @Override
  public void borrowFromPrev(int index) {
      // TODO: Implement left sibling borrow
  }

  @Override
  public void borrowFromNext(int index) {
      // TODO: Implement right sibling borrow
  }

  @Override
  public void merge(int index) {
      // TODO: Implement merge with right sibling
  }

    @Override
    public BTreeNode[] getChildren() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getValueAt(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
  
}
