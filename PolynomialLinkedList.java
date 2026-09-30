import java.util.Scanner;

public class PolynomialLinkedList {

    // Node of polynomial
    static class Node {
        int coefficient;
        int exponent;
        Node next;

        Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }

    // Insert a term at the end
    static Node insert(Node head, int coefficient, int exponent) {

        Node newNode = new Node(coefficient, exponent);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    // Display polynomial
    static void display(Node head) {

        Node temp = head;

        while (temp != null) {

            if (temp.coefficient != 0) {
                if (temp != head && temp.coefficient > 0) {
                    System.out.print(" + ");
                }

                System.out.print(temp.coefficient);

                if (temp.exponent > 0) {
                    System.out.print("x");

                    if (temp.exponent > 1) {
                        System.out.print("^" + temp.exponent);
                    }
                }
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter coefficient of term " + i + ": ");
            int coefficient = sc.nextInt();

            System.out.print("Enter exponent of term " + i + ": ");
            int exponent = sc.nextInt();

            head = insert(head, coefficient, exponent);
        }

        System.out.println("\nPolynomial:");
        display(head);

        sc.close();
    }
}