import java.util.Set;

public interface Map<K, V> {
    /**
     * Inserts a key-value pair into the map.
     * If the key already exists, updates the value.
     * @param key   The key to insert
     * @param value The value associated with the key
     */
    void put(K key, V value);

    /**
     * Retrieves the value associated with the given key.
     * @param key The key to look up
     * @return The associated value, or null if key not found
     */
    V get(K key);

    /**
     * Checks if a key is present in the map.
     * @param key The key to check
     * @return true if the key exists, false otherwise
     */
    boolean containsKey(K key);

    /**
     * Removes a key-value pair from the map.
     * @param key The key to remove
     * @return The previous value associated with the key, or null if key was not found
     */
    V remove(K key);

    /**
     * Returns the number of key-value pairs in the map.
     * @return The size of the map
     */
    int size();

    /**
     * Returns a set of all keys in the map.
     * @return A set of keys
     */
    Set<K> keySet();

    /**
     * Checks if the map is empty.
     * @return true if the map contains no elements, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all key-value pairs from the map.
     */
    void clear();

    /**
     * Returns the underlying array of entries.
     * @return An array of Map.Entry objects representing the key-value pairs
     */
    Object[] toArray(); 
}
