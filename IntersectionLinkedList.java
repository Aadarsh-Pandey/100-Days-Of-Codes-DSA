import java.util.Scanner;

public class IntersectionLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find intersection point
    static Node findIntersection(Node head1, Node head2) {

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {

            if (p1 == null) {
                p1 = head2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = head1;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }

    // Create a linked list
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

    // Display list
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

        System.out.println("Enter first list:");
        Node head1 = createList(n1, sc);

        System.out.print("Enter number of nodes in second list: ");
        int n2 = sc.nextInt();

        System.out.println("Enter second list:");
        Node head2 = createList(n2, sc);

        Node intersection = findIntersection(head1, head2);

        if (intersection != null) {
            System.out.println("Intersection point = " + intersection.data);
        } else {
            System.out.println("No intersection point");
        }

        sc.close();
    }
}
