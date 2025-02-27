public class SymbolTable<K, V> {
    // TODO: Implement a symbol table that allows stacking of scopes
    // Requirements:
    // 1. Maps keys to values while allowing scope stacking.
    // 2. Variables with the same name in different scopes should hide each other (lowest scope wins).
    // 3. Popping a scope removes only variables from that scope while retaining others.
    // 4. Variables in the main scope are always available unless hidden.
    // 5. Allows pushing a new scope and popping it off again.
    // 6. When creating a new scope, it should be possible to give it a name.
    // 7. Named scopes allow explicit access to hidden variables from other scopes.
    
    public SymbolTable() {
        // TODO: Implement constructor
    }

    public void put(K key, V value) {
        // TODO: Implement method to add a variable to the current scope
    }

    public V get(K key) {
        // TODO: Implement method to retrieve a variable from the closest scope
        return null;
    }

    public void pushScope(String scopeName) {
        // TODO: Implement method to create a new named scope
    }

    public void popScope() {
        // TODO: Implement method to remove the current scope
    }

    public V getFromScope(String scopeName, K key) {
        // TODO: Implement method to explicitly retrieve a variable from a named scope
        return null;
    }
}
