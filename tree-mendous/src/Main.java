


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        
        System.out.println("Enter numbers to insert into the BST (type 'end' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                bst.insert(value);
            } else if (scanner.next().equals("end")) {
                break;
            }
        }
        
        System.out.println("BST Created. Performing Traversals:");
        System.out.println("In-order Traversal: " + bst.inOrderTraversal());
        System.out.println("Pre-order Traversal: " + bst.preOrderTraversal());
        System.out.println("Post-order Traversal: " + bst.postOrderTraversal());
        
        System.out.println("Tree Height: " + bst.getHeight());
        
        System.out.print("Enter a node value to find its depth: ");
        int node = scanner.nextInt();
        System.out.println("Depth of " + node + " is: " + bst.getDepth(node));
        
        System.out.println("Level Order Traversal: " + bst.levelOrderTraversal());
        
        System.out.println("ASCII Representation:");
        bst.printAsciiTree();
    }
}


