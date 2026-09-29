import java.util.Scanner;

public class CircularLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    // Create circular linked list
    static void createList(int n, Scanner sc) {

        Node temp = null;

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter element " + i + ": ");
            int data = sc.nextInt();

            // Dynamically create a new node
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        // Make the last node point back to head
        if (temp != null) {
            temp.next = head;
        }
    }

    // Traverse circular linked list
    static void traverse() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.println("\nCircular Linked List:");

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        createList(n, sc);

        traverse();

        sc.close();
    }
}