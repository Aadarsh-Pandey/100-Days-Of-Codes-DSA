import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input element and position
        System.out.print("Enter element to insert: ");
        int x = sc.nextInt();

        System.out.print("Enter position (1-based): ");
        int pos = sc.nextInt();

        // Shift elements to the right
        for (int i = n; i >= pos; i--) {
            arr[i] = arr[i - 1];
        }

        // Insert element
        arr[pos - 1] = x;

        // Print updated array
        System.out.println("Array after insertion:");
        for (int i = 0; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}