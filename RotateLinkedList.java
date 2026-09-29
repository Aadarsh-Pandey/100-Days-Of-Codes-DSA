import java.util.Scanner;

public class RotateLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Create linked list
    static Node createList(int n, Scanner sc) {

        Node head = null;
        Node temp = null;

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter element " + i + ": ");
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

    // Rotate linked list right by k places
    static Node rotateRight(Node head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and last node
        int length = 1;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Avoid unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        // Find new tail
        int steps = length - k;
        Node newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is after new tail
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        head = rotateRight(head, k);

        System.out.println("After rotating right by " + k + " places:");
        display(head);

        sc.close();
    }
}