import java.util.Set;

public class AddressProbeHashMap<K, V> implements Map<K, V> {
  /**
   * TODO: Implement a hash map using open addressing with linear probing for collision resolution.
   * TODO: Ensure to respect the load factor and resize the array when necessary.
   * TODO: Make sure you don't create any probe cycles. more random stuff
   */

    private int capacity;
    private float loadFactor;

    public AddressProbeHashMap(int initialCapacity, float loadFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(K key, V value) {} 

    @Override
    public V get(K key) { return null; }

    @Override
    public boolean containsKey(K key) { return false; }

    @Override
    public V remove(K key) { return null; }

    @Override
    public int size() { return 0; }

    @Override
    public Set<K> keySet() { return null; }

    @Override
    public boolean isEmpty() { return true; }

    @Override
    public void clear() {}

    @Override
    public Object[] toArray() { return null; }
}
