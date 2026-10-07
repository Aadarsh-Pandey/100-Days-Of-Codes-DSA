import java.util.Scanner;

public class Deque {

    // Node of Doubly Linked List
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node front = null;
    static Node rear = null;
    static int size = 0;

    // Insert at front
    static void push_front(int value) {
        Node newNode = new Node(value);

        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    // Insert at rear
    static void push_back(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;
    }

    // Delete from front
    static void pop_front() {
        if (front == null) {
            return;
        }

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;
    }

    // Delete from rear
    static void pop_back() {
        if (rear == null) {
            return;
        }

        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;
    }

    // Get front element
    static int front() {
        if (front == null) {
            return -1;
        }

        return front.data;
    }

    // Get rear element
    static int back() {
        if (rear == null) {
            return -1;
        }

        return rear.data;
    }

    // Check empty
    static boolean empty() {
        return size == 0;
    }

    // Return size
    static int getSize() {
        return size;
    }

    // Display deque
    static void display() {
        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Example operations
        push_back(10);
        push_back(20);
        push_front(5);

        System.out.println("Deque:");
        display();

        System.out.println("Front: " + front());
        System.out.println("Back: " + back());
        System.out.println("Size: " + getSize());

        pop_front();
        System.out.println("After pop_front:");
        display();

        pop_back();
        System.out.println("After pop_back:");
        display();

        System.out.println("Is Empty: " + empty());

        sc.close();
    }
}