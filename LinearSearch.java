import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int k = sc.nextInt();

        int comparisons = 0;
        int position = -1;

        // Linear Search
        for (int i = 0; i < n; i++) {
            comparisons++;

            if (arr[i] == k) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.println("Key found at index: " + position);
        } else {
            System.out.println("Key not found");
        }

        System.out.println("Number of comparisons: " + comparisons);
    }
}