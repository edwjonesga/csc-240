
import java.io.IOException;
import java.io.RandomAccessFile;

public class PersistentIntegerBTreeNode implements PersistentBTreeNode {

/**
 * An implementation of a persistent B-tree node that stores integer values.
 * This version supports reading from and writing to a RandomAccessFile.
 * NOTE: It is strongly recommended that you get the non persistent B-tree working first before going after this.
 * feel free to modify IntegerBTreeNode so that you can extend it with this class as a sub-class.
 */
    protected int t;
    protected int[] values;
    protected PersistentBTreeNode[] children;
    protected int numValues;
    protected boolean isLeaf;

    protected long offset = -1;
    protected boolean dirty = true;
    protected RandomAccessFile file;

    public PersistentIntegerBTreeNode(int t, boolean isLeaf) {
        this.t = t;
        this.isLeaf = isLeaf;
        this.values = new int[2 * t - 1];
        this.children = new PersistentBTreeNode[2 * t];
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
        // TODO: Implement disk-aware search if needed
        return null;
    }

    @Override
    public void insertNonFull(int value) {
        // TODO: Implement insert for persistent nodes
    }

    @Override
    public void splitChild(int index, BTreeNode fullChild) {
        // TODO: Implement splitChild for persistent nodes
    }

    @Override
    public String traverse() {
        // TODO: Implement traversal with optional on-disk loading
        return "";
    }

    @Override
    public void remove(int value) {
        // TODO: Implement deletion with persistence
    }

    @Override
    public int getPredecessor(int index) {
        return -1;
    }

    @Override
    public int getSuccessor(int index) {
        return -1;
    }

    @Override
    public void borrowFromPrev(int index) {
        // TODO
    }

    @Override
    public void borrowFromNext(int index) {
        // TODO
    }

    @Override
    public void merge(int index) {
        // TODO
    }

    // -------- Persistence Methods --------

    @Override
    public byte[] toByteArray() {
        // TODO: Serialize this node into a fixed-size byte array
        return new byte[0];
    }

    @Override
    public void fromByteArray(byte[] bytes) {
        // TODO: Deserialize a node from the given bytes
    }

    @Override
    public void setFile(RandomAccessFile file) {
        this.file = file;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public void setOffset(long offset) {
        this.offset = offset;
    }

    @Override
    public void writeToDisk() {
        if (file == null || offset < 0) {
            throw new IllegalStateException("File or offset not set");
        }
        try {
            file.seek(offset);
            file.write(toByteArray());
            markClean();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write node to disk", e);
        }
    }

    @Override
    public void readFromDisk(long offset) {
        if (file == null) {
            throw new IllegalStateException("File not set");
        }
        try {
            file.seek(offset);
            byte[] buffer = new byte[getNodeSizeInBytes()];
            file.readFully(buffer);
            fromByteArray(buffer);
            this.offset = offset;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read node from disk", e);
        }
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }

    @Override
    public void markClean() {
        dirty = false;
    }

    @Override
    public void markDirty() {
        dirty = true;
    }

    // Optional: calculate fixed node size
    protected int getNodeSizeInBytes() {
        // Placeholder: you'll need to calculate based on number of ints, booleans, offsets, etc.
        return 4096; // For example, one page size
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
