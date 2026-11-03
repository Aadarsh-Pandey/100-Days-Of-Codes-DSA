import java.util.*;

public class CountingSort {

    static void countingSort(int[] arr) {
        int n = arr.length;

        // 1. Find maximum element
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // 2. Create frequency array
        int[] freq = new int[max + 1];

        for (int num : arr) {
            freq[num]++;
        }

        // 3. Calculate prefix sums
        for (int i = 1; i <= max; i++) {
            freq[i] += freq[i - 1];
        }

        // 4. Build output array (right to left for stability)
        int[] output = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            output[freq[num] - 1] = num;
            freq[num]--;
        }

        // 5. Copy output back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        countingSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}