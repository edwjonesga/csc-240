
public class Main {
    public static void main(String[] args) {
        boolean directed = false;
        boolean weighted = true;
        Graph<String> g1 = new AdjacencyMatrixGraph<>(directed, weighted);
        g1.addEdge("A", "B", 10);
        g1.addEdge("B", "C", 5);
        g1.printGraph();

        System.out.println();

        Graph<String> g2 = new AdjacencyListGraph<>(directed, weighted);
        g2.addEdge("X", "Y");
        g2.addEdge("Y", "Z");
        g2.printGraph();
    }
}

