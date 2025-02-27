import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MainTest {
    private Phonebook phonebook;
    private LRUCache<Integer, String> lruCache;
    private SymbolTable<String, String> symbolTable;

    @BeforeEach
    void setUp() {
        phonebook = new Phonebook();
        lruCache = new LRUCache<>(3);
        symbolTable = new SymbolTable<>();
    }

    @Test
    void testPhonebook() {
        phonebook.addContact("Alice", "1234");
        phonebook.addContact("Bob", "5678");
        assertEquals("1234", phonebook.getContact("Alice"));
        assertTrue(phonebook.containsContact("Bob"));
        assertFalse(phonebook.containsContact("Charlie"));
    }

    @Test
    void testLRUCache() {
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");
        assertEquals("One", lruCache.get(1));
        lruCache.put(4, "Four"); // This should evict the least recently used key
        assertNull(lruCache.get(2));
        assertEquals("Four", lruCache.get(4));
    }

    @Test
    void testSymbolTableScopes() {
        symbolTable.put("x", "global");
        symbolTable.pushScope("local1");
        symbolTable.put("x", "local1");
        assertEquals("local1", symbolTable.get("x")); // Local scope wins
        assertEquals("global", symbolTable.getFromScope("global", "x")); // Access global explicitly

        symbolTable.pushScope("local2");
        symbolTable.put("x", "local2");
        assertEquals("local2", symbolTable.get("x")); // Newest scope wins

        symbolTable.popScope();
        assertEquals("local1", symbolTable.get("x")); // Back to previous scope

        symbolTable.popScope();
        assertEquals("global", symbolTable.get("x")); // Back to global scope
    }
}