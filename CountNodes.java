import java.util.Scanner;

public class CountNodes {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        // Create linked list
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

        // Count nodes
        int count = 0;
        temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Number of nodes = " + count);

        sc.close();
    }
}