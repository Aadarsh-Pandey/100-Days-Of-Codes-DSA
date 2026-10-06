import java.util.Scanner;

public class Main {

    // Node of Circular Queue
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
        if (front == null) {
            front = newNode;
            rear = newNode;

            // Make queue circular
            rear.next = front;
        } 
        else {
            rear.next = newNode;
            rear = newNode;

            // Maintain circular connection
            rear.next = front;
        }
    }

    // Dequeue operation
    static void dequeue() {

        // If queue is empty
        if (front == null) {
            return;
        }

        // Only one element
        if (front == rear) {
            front = null;
            rear = null;
        } 
        else {
            front = front.next;
            rear.next = front;
        }
    }

    // Display queue
    static void display() {

        if (front == null) {
            return;
        }

        Node temp = front;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
        int n = sc.nextInt();

        // Enqueue n elements
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            enqueue(value);
        }

        // Number of dequeue operations
        int m = sc.nextInt();

        // Perform dequeue operations
        for (int i = 0; i < m; i++) {
            dequeue();
        }

        // Print queue from front to rear
        display();

        sc.close();
    }
}