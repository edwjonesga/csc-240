public class Main {
    public static void main(String[] args) {
        System.out.println("🔧 Testing BinaryHeap<T> with Integer values...");

        BinaryHeap<Integer> heap = new BinaryHeap<>(10);

        System.out.println("Adding elements: 7, 3, 9, 1");
        heap.add(7);
        heap.add(3);
        heap.add(9);
        heap.add(1);

        System.out.println("Current size: " + heap.size());
        System.out.println("Top of heap (peek): " + heap.peek());

        System.out.println("Removing root: " + heap.removeRoot());
        System.out.println("Next root after removal: " + heap.peek());

        System.out.println("Adding element: 2");
        heap.add(2);

        System.out.println("Removing all elements:");
        while (!heap.isEmpty()) {
            System.out.println("Removed: " + heap.removeRoot());
        }

        System.out.println("✅ Manual testing complete.");
    }
}

