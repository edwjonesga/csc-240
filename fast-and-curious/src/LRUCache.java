import java.util.List;
public class LRUCache<K, V> {
    // TODO: Implement a Least Recently Used (LRU) cache
    // Requirements:
    // 1. Caches a specified capacity of key-value pairs
    // 2. Keeps track of the last time a key was accessed relative to other keys in the cache
    // 3. Bounces items that have been least recently accessed to make room for new items
    // 4. Allows adding items to the cache
    // 5. Allows accessing items in the cache
    // 6. Provides a method to retrieve the LRU order for testing purposes
    // Efficiency is key, so make use of all data structures at your disposal.

    public LRUCache(int capacity) {
        // TODO: Implement constructor
    }

    public void put(K key, V value) {
        // TODO: Implement method to add items to the cache
    }

    public V get(K key) {
        // TODO: Implement method to retrieve items from the cache
        return null;
    }

    public List<K> getLRUOrder() {
        // TODO: Implement method to retrieve LRU order
        return null;
    }
}
