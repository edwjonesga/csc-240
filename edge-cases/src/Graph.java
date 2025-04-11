public interface Graph<T> {
    void addEdge(T from, T to);                 // For unweighted
    void addEdge(T from, T to, int weight);     // For weighted
    boolean hasEdge(T from, T to);
    void removeEdge(T from, T to);
    void printGraph(); // Outputs: A ----10----> B or A ------- B
}
