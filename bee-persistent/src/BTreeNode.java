public interface BTreeNode {
/**
 * Represents a node in a B-tree. Students are expected to implement this interface
 * as part of their B-tree implementation. Each node may store multiple values and
 * have multiple children, depending on the degree of the B-tree.
 * Resource: https://www.youtube.com/watch?v=K1a2Bk8NrYQ
 */
    /**
     * @return true if this node is a leaf (i.e., it has no children), false otherwise.
     * Hint: Leaf nodes will always insert directly into their values array.
     */
    boolean isLeaf();

    /**
     * @return the number of values currently stored in this node.
     * Hint: This value changes during insertions and deletions.
     */
    int getNumValues();

    /**
     * Searches for a value in this node or its children.
     * @param value the integer value to search for.
     * @return the BTreeNode that contains the value, or null if not found.
     * Hint: Search through the values array. If not found and not a leaf,
     * descend into the correct child.
     */
    BTreeNode search(int value);

    /**
     * Inserts a value into this node assuming the node is not full.
     * @param value the value to insert.
     * Hint: If the node is a leaf, insert the value into the sorted position.
     * If not, recurse into the correct child after ensuring it's not full.
     */
    void insertNonFull(int value);

    /**
     * Splits the full child node at the specified index.
     * @param index the index of the child to split.
     * @param fullChild the actual reference to the child node (should be full).
     * Hint: Move the middle value of the child up to this node, and break
     * the child into two smaller nodes.
     */
    void splitChild(int index, BTreeNode fullChild);

    /**
     * Traverses the tree rooted at this node and prints the values in sorted order.
     * Hint: Use in-order traversal logic. Visit children in order between values.
     * @return an in-order string representation of this node and all its children.
     */
    String traverse();

    /**
     * Removes the specified value from the subtree rooted at this node.
     * @param value the value to remove.
     * Hint: Handle cases where the value is in this node or must be found in a child.
     * Be sure to merge or borrow before descending into a child with t - 1 values.
     */
    void remove(int value);

    /**
     * @param index the index of the value in this node whose predecessor we want.
     * @return the predecessor value (i.e., largest value in left subtree).
     * Hint: Go to the left child and move right as far as possible.
     */
    int getPredecessor(int index);

    /**
     * @param index the index of the value in this node whose successor we want.
     * @return the successor value (i.e., smallest value in right subtree).
     * Hint: Go to the right child and move left as far as possible.
     */
    int getSuccessor(int index);

    /**
     * Borrows a value from the left sibling of the child at index and updates the tree.
     * @param index index of the child that is too small (t - 1 values).
     * Hint: Shift a value from the parent into the child, and move the sibling’s
     * last value up to the parent.
     */
    void borrowFromPrev(int index);

    /**
     * Borrows a value from the right sibling of the child at index and updates the tree.
     * @param index index of the child that is too small (t - 1 values).
     * Hint: Similar to borrowFromPrev, but the direction of movement is reversed.
     */
    void borrowFromNext(int index);

    /**
     * Merges the child at index with its right sibling and moves a value down from the parent.
     * @param index index of the left child involved in the merge.
     * Hint: The value between the two children in the parent goes down into the new node.
     * The merged node will now have 2t - 1 values.
     */
    void merge(int index);
  /**
 * Returns the value stored at the specified index within this node.
 *
 * @param index the position of the value to retrieve (0-based).
 *              Must be less than {@code getNumValues()}.
 * @return the integer value stored at the given index.
 * @throws IndexOutOfBoundsException if the index is invalid.
 *
 * <p>Hint for students: Values within a node are stored in sorted order.
 * Use this method when you need to determine whether to insert into or
 * descend through a particular child node.</p>
 */
int getValueAt(int index);

/**
 * Returns an array of child nodes for this B-tree node.
 *
 * @return an array of {@code BTreeNode} references representing the children.
 *         For leaf nodes, this may be null or an empty array.
 *
 * <p>Note: The number of non-null children should be {@code getNumValues() + 1}
 * if this is an internal node. Children correspond to the value "gaps"—
 * one more than the number of values stored.</p>
 *
 * <p>Hint for students: Use this array to navigate to the correct child
 * during insert, search, or delete operations. Always check {@code isLeaf()}
 * before assuming children exist.</p>
 */
BTreeNode[] getChildren();


}
