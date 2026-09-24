import java.util.Arrays;
import java.util.Scanner;

public class ClosestToZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int minSum = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            // Check if this sum is closer to zero
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                first = arr[left];
                second = arr[right];
            }

            // Move pointers
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                // Sum is exactly zero
                break;
            }
        }

        System.out.println("Two elements: " + first + " and " + second);
        System.out.println("Closest sum to zero: " + minSum);

        sc.close();
    }
}