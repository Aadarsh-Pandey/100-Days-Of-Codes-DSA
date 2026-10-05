import java.util.Scanner;

public class QueueUsingLinkedList {

    // Node of the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    // Enqueue operation
    static void enqueue(int value) {

        Node newNode = new Node(value);

        // If queue is empty
        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        // Add new node at rear
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue operation
    static void dequeue() {

        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(front.data + " removed from queue.");

        front = front.next;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }
    }

    // Display queue
    static void display() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;

        System.out.println("Queue elements:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    enqueue(value);
                    System.out.println(value + " inserted into queue.");
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}