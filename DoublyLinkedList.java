import java.util.Scanner;

public class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static Node head = null;

    // Insert node at the end
    static void insert(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // Move to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect new node
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Forward traversal
    static void forwardTraversal() {

        Node temp = head;

        System.out.println("\nForward Traversal:");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Backward traversal
    static void backwardTraversal() {

        if (head == null) {
            return;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println("\nBackward Traversal:");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Create and insert nodes
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            int data = sc.nextInt();

            insert(data);
        }

        // Traverse in both directions
        forwardTraversal();
        backwardTraversal();

        sc.close();
    }
}