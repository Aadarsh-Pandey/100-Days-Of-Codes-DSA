import java.util.Scanner;

public class CountOccurrences {

    // Node class
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

        return head;
    }

    // Count occurrences of key
    static int countOccurrences(Node head, int key) {

        int count = 0;
        Node current = head;

        while (current != null) {

            if (current.data == key) {
                count++;
            }

            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = createList(n, sc);

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int count = countOccurrences(head, key);

        System.out.println("Number of occurrences of " + key + " = " + count);

        sc.close();
    }
}
