import java.util.Scanner;

public class Heapsort {

    // Heapify subtree rooted at index i
    static void heapify(int[] arr, int n, int i) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not the root
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Heap Sort
    static void heapSort(int[] arr) {

        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract maximum one by one
        for (int i = n - 1; i > 0; i--) {

            // Move maximum element to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify remaining elements
            heapify(arr, i, 0);
        }
    }

    // Display array
    static void display(int[] arr) {

        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        heapSort(arr);

        display(arr);

        sc.close();
    }
}