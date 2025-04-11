import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testAdjacencyMatrixDirectedWeighted() {
        Graph<String> graph = new AdjacencyMatrixGraph<>(true, true);
        runBasicGraphTests(graph, true, true);
    }

    @Test
    public void testAdjacencyMatrixUndirectedUnweighted() {
        Graph<String> graph = new AdjacencyMatrixGraph<>(false, false);
        runBasicGraphTests(graph, false, false);
    }

    @Test
    public void testAdjacencyListDirectedWeighted() {
        Graph<String> graph = new AdjacencyListGraph<>(true, true);
        runBasicGraphTests(graph, true, true);
    }

    @Test
    public void testAdjacencyListUndirectedUnweighted() {
        Graph<String> graph = new AdjacencyListGraph<>(false, false);
        runBasicGraphTests(graph, false, false);
    }

    private void runBasicGraphTests(Graph<String> graph, boolean directed, boolean weighted) {
        // Add edges
        graph.addEdge("A", "B", 10);
        graph.addEdge("B", "C", 5);
        graph.addEdge("C", "A", 3);
        graph.addEdge("D", "E");
        graph.addEdge("F", "G");

        // Check hasEdge in correct direction
        assertTrue(graph.hasEdge("A", "B"), "Edge A->B should exist");
        assertTrue(graph.hasEdge("B", "C"), "Edge B->C should exist");
        assertTrue(graph.hasEdge("C", "A"), "Edge C->A should exist");
        assertTrue(graph.hasEdge("F", "G"), "Edge F->G should exist");

        // Undirected graphs should mirror edges
        if (!directed) {
            assertTrue(graph.hasEdge("B", "A"), "Edge B->A should exist (undirected)");
            assertTrue(graph.hasEdge("C", "B"), "Edge C->B should exist (undirected)");
            assertTrue(graph.hasEdge("A", "C"), "Edge A->C should exist (undirected)");
            assertTrue(graph.hasEdge("G", "F"), "Edge G->F should exist (undirected)");
        } else {
            assertFalse(graph.hasEdge("B", "A"), "Edge B->A should not exist (directed)");
            assertFalse(graph.hasEdge("C", "B"), "Edge C->B should not exist (directed)");
        }

        // Remove edge and retest
        graph.removeEdge("B", "C");
        assertFalse(graph.hasEdge("B", "C"), "Edge B->C should be removed");
        if (!directed) {
            assertFalse(graph.hasEdge("C", "B"), "Edge C->B should be removed in undirected mode");
        }
    }
}
