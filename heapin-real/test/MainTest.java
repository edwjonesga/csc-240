import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private BinaryHeap<Integer> heap;

    @BeforeEach
    public void setUp() {
        heap = new BinaryHeap<>(10);
    }

    @Test
    public void testAddSingleElement() {
        heap.add(42);
        assertEquals(1, heap.size());
        assertEquals(42, heap.peek());
    }

    @Test
    public void testAddMultipleAndPeekMin() {
        heap.add(10);
        heap.add(4);
        heap.add(7);
        assertEquals(3, heap.size());
        assertEquals(4, heap.peek(), "Peek should return the smallest element in a min-heap");
    }

    @Test
    public void testRemoveRoot() {
        heap.add(5);
        heap.add(2);
        heap.add(8);
        assertEquals(2, heap.removeRoot());
        assertEquals(2, heap.size());
        assertEquals(5, heap.peek(), "Next smallest value should become new root");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.add(1);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testRemoveUntilEmpty() {
        heap.add(3);
        heap.add(1);
        heap.add(6);
        heap.removeRoot();
        heap.removeRoot();
        heap.removeRoot();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testExceptionOnRemoveFromEmpty() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            heap.removeRoot();
        });
        assertTrue(exception.getMessage().contains("Heap is empty"));
    }

    @Test
    public void testExceptionOnAddBeyondCapacity() {
        BinaryHeap<Integer> smallHeap = new BinaryHeap<>(2);
        smallHeap.add(1);
        smallHeap.add(2);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            smallHeap.add(3);
        });
        assertTrue(exception.getMessage().contains("Heap is full"));
    }
}
