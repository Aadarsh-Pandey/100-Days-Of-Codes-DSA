import java.util.Scanner;

public class Heap {

    static int[] heap;
    static int size = 0;

    // Insert element into Min Heap
    static void insert(int value) {

        heap[size] = value;
        int i = size;
        size++;

        // Move element upward
        while (i > 0) {

            int parent = (i - 1) / 2;

            if (heap[parent] <= heap[i]) {
                break;
            }

            // Swap parent and child
            int temp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = temp;

            i = parent;
        }
    }

    // Delete minimum element (root)
    static int deleteMin() {

        if (size == 0) {
            return -1;
        }

        int min = heap[0];

        // Move last element to root
        heap[0] = heap[size - 1];
        size--;

        // Move element downward
        int i = 0;

        while (true) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            // Check left child
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            // Check right child
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            // Already in correct position
            if (smallest == i) {
                break;
            }

            // Swap
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }

        return min;
    }

    // Get minimum element
    static int peek() {

        if (size == 0) {
            return -1;
        }

        return heap[0];
    }

    // Display heap
    static void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        heap = new int[n];

        // Insert elements
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            insert(value);
        }

        System.out.println("Min Heap:");
        display();

        System.out.println("Minimum: " + peek());

        System.out.println("Deleted: " + deleteMin());

        System.out.println("After deletion:");
        display();

        sc.close();
    }
}