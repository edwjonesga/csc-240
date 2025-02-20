import java.util.Set;
public class SeparateChainHashMap<K, V> implements Map<K, V> {
      
  /**
   * TODO: Implement a hash map using the separate chaining method for resolving collisions.
   * TODO: Make sure to respect the load factor and resize the array when adding a new member will exceed the load factor.
   */
    private int capacity;
    private float loadFactor;

    public SeparateChainHashMap(int initialCapacity, float loadFactor) {
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
