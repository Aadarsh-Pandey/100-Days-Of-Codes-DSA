import java.util.Scanner;

public class SinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    static Node head = null;

    // Create the linked list
    static void createList(int n, Scanner sc) {

        Node temp = null;

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter element " + i + ": ");
            int data = sc.nextInt();

            Node newNode = new Node(data);

            if (head == null) {
                // First node becomes head
                head = newNode;
                temp = newNode;
            } else {
                // Attach new node to the end
                temp.next = newNode;
                temp = newNode;
            }
        }
    }

    // Traverse the linked list
    static void traverse() {

        Node current = head;

        System.out.println("\nLinked List:");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
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
