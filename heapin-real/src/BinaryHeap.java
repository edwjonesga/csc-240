public class BinaryHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public BinaryHeap(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    /**
     * Adds a new element to the heap.
     * Students must maintain the heap property.
     */
    public void add(T value) {
    }

    /**
     * Removes and returns the element with the highest priority (min or max depending on heap type).
     * Students must maintain the heap property after removal.
     */
    public T removeRoot() {
      return null;
    }

    /**
     * Returns the element at the root of the heap without removing it.
     */
    public T peek() {
      return null;
    }

    private void bubbleUp(int index) {
    }

    private void bubbleDown(int index) {
        // TODO: Implement bubbling down to restore heap property
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
