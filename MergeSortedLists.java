import java.util.Scanner;

public class MergeSortedLists {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Merge two sorted linked lists
    static Node merge(Node head1, Node head2) {

        // Dummy node to make merging easier
        Node dummy = new Node(0);
        Node temp = dummy;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }

            temp = temp.next;
        }

        // Add remaining nodes
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

        return dummy.next;
    }

    // Create a linked list
    static Node createList(int n, Scanner sc) {

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {

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

        System.out.print("Enter number of nodes in first list: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements in sorted order:");
        Node head1 = createList(n1, sc);

        System.out.print("Enter number of nodes in second list: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements in sorted order:");
        Node head2 = createList(n2, sc);

        Node mergedHead = merge(head1, head2);

        System.out.println("Merged Sorted Linked List:");
        display(mergedHead);

        sc.close();
    }
}
