import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map.Entry;

public class MainTest {
    private SeparateChainHashMap<String, Integer> separateChainMap;
    private AddressProbeHashMap<String, Integer> addressProbeMap;

    @BeforeEach
    void setUp() {
        separateChainMap = new SeparateChainHashMap<>(5, 0.75f);
        addressProbeMap = new AddressProbeHashMap<>(5, 0.75f);
    }

    @Test
    void testPutAndGet() {
        separateChainMap.put("one", 1);
        addressProbeMap.put("one", 1);
        assertEquals(1, separateChainMap.get("one"));
        assertEquals(1, addressProbeMap.get("one"));
    }

    @Test
    void testContainsKey() {
        separateChainMap.put("two", 2);
        addressProbeMap.put("two", 2);
        assertTrue(separateChainMap.containsKey("two"));
        assertTrue(addressProbeMap.containsKey("two"));
        assertFalse(separateChainMap.containsKey("three"));
        assertFalse(addressProbeMap.containsKey("three"));
    }

    @Test
    void testRemove() {
        separateChainMap.put("three", 3);
        addressProbeMap.put("three", 3);
        assertEquals(3, separateChainMap.remove("three"));
        assertEquals(3, addressProbeMap.remove("three"));
        assertNull(separateChainMap.get("three"));
        assertNull(addressProbeMap.get("three"));
    }

    @Test
    void testSize() {
        separateChainMap.put("one", 1);
        addressProbeMap.put("one", 1);
        separateChainMap.put("two", 2);
        addressProbeMap.put("two", 2);
        assertEquals(2, separateChainMap.size());
        assertEquals(2, addressProbeMap.size());
    }

    @Test
    void testUpdateValue() {
        separateChainMap.put("one", 1);
        addressProbeMap.put("one", 1);
        separateChainMap.put("one", 10);
        addressProbeMap.put("one", 10);
        assertEquals(10, separateChainMap.get("one"));
        assertEquals(10, addressProbeMap.get("one"));
    }

    @Test
    void testResize() {
        for (int i = 0; i < 10; i++) {
            separateChainMap.put("key" + i, i);
            addressProbeMap.put("key" + i, i);
        }
        assertEquals(10, separateChainMap.size());
        assertEquals(10, addressProbeMap.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(separateChainMap.isEmpty());
        assertTrue(addressProbeMap.isEmpty());
        separateChainMap.put("one", 1);
        addressProbeMap.put("one", 1);
        assertFalse(separateChainMap.isEmpty());
        assertFalse(addressProbeMap.isEmpty());
        
        separateChainMap.remove("one");
        addressProbeMap.remove("one");
        assertTrue(separateChainMap.isEmpty());
        assertTrue(addressProbeMap.isEmpty());
    }

    @Test
    void testToArrayResizing() {
        Entry<String, Integer>[] beforeSeparate = separateChainMap.toArray();
        Entry<String, Integer>[] beforeAddress = addressProbeMap.toArray();

        for (int i = 0; i < 3; i++) {  // Load factor of 0.75 * 5 = 3.75, so resizing should happen when adding the 4th element
            separateChainMap.put("key" + i, i);
            addressProbeMap.put("key" + i, i);
        }

        separateChainMap.put("trigger", 100);
        addressProbeMap.put("trigger", 100);

        Entry<String, Integer>[] afterSeparate = separateChainMap.toArray();
        Entry<String, Integer>[] afterAddress = addressProbeMap.toArray();

        assertTrue(afterSeparate.length >= beforeSeparate.length * 2);
        assertTrue(afterAddress.length >= beforeAddress.length * 2);
    }
}
