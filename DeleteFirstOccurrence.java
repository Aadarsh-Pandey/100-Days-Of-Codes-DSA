import java.util.Scanner;

public class DeleteFirstOccurrence {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Delete first occurrence of key
    static Node deleteFirst(Node head, int key) {

        // If list is empty
        if (head == null) {
            return null;
        }

        // If key is in the first node
        if (head.data == key) {
            return head.next;
        }

        Node current = head;

        // Search for the key
        while (current.next != null) {

            if (current.next.data == key) {
                // Delete the node
                current.next = current.next.next;
                break;
            }

            current = current.next;
        }

        return head;
    }

    // Create linked list
    static Node createList(int n, Scanner sc) {

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {

            System.out.print("Enter element " + (i + 1) + ": ");
            int data = sc.nextInt();

            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        return head;
    }

    // Display linked list
    static void display(Node head) {

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = createList(n, sc);

        System.out.println("\nOriginal Linked List:");
        display(head);

        System.out.print("Enter key to delete: ");
        int key = sc.nextInt();

        head = deleteFirst(head, key);

        System.out.println("After deleting first occurrence:");
        display(head);

        sc.close();
    }
}