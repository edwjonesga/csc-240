public class ReversingLinkedList {
    
    // Points: 50
    // Instructions:
    // Implement a linked list that reverses its order every n inserts.
    // You can use your previous linked list implementation and any other data structures.
    
    private class Node {
        int data;
        Node next;
        public Node(int data) { this.data = data; this.next = null; }
    }
    
    private Node head;
    private int count;
    private int n;

    public ReversingLinkedList(int n) {
        this.n = n;
        this.count = 0;
    }
    
    public void insert(int value) {
        // TODO: Implement insert logic.
        // Reverse the linked list every n inserts.
    }
}
