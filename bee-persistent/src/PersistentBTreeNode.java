public interface PersistentBTreeNode extends BTreeNode {

/**
 * An extension of BTreeNode that supports persistence to disk.
 * Implementations should be able to serialize and deserialize themselves
 * and manage their location in a backing RandomAccessFile.
 */
    /**
     * Serializes this node into a byte array representation.
     * This should include metadata (e.g., isLeaf, numValues), values, and children offsets.
     * @return a byte array that can be written to disk.
     */
    byte[] toByteArray();

    /**
     * Populates this node's fields from a given byte array.
     * Used when reading a node from disk.
     * @param bytes the serialized node contents read from file.
     */
    void fromByteArray(byte[] bytes);

    /**
     * Sets the file that this node will use for persistence.
     * This must be called before performing any disk I/O.
     * @param file a reference to a RandomAccessFile that stores all B-tree nodes.
     */
    void setFile(java.io.RandomAccessFile file);

    /**
     * @return the offset in the file where this node is stored.
     * Hint: useful for tracking child references as offsets.
     */
    long getOffset();

    /**
     * Sets the offset for this node in the backing file.
     * This is usually done when the node is first written to disk.
     * @param offset the byte position in the file.
     */
    void setOffset(long offset);

    /**
     * Writes the current node to disk at its assigned offset.
     * If the offset is not yet assigned, this method should throw an exception.
     */
    void writeToDisk();

    /**
     * Reads this node’s content from disk at the given offset.
     * Should overwrite the current in-memory contents.
     * @param offset the byte position in the file to read from.
     */
    void readFromDisk(long offset);

    /**
     * @return true if this node has been modified since the last disk write.
     * Used to support caching and flushing strategies.
     */
    boolean isDirty();

    /**
     * Marks this node as clean (not dirty).
     * Should be called after writing to disk.
     */
    void markClean();

    /**
     * Marks this node as dirty (needing to be written).
     * Should be called after any modification to the node.
     */
    void markDirty();
}
