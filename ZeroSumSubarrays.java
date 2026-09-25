import java.util.HashMap;
import java.util.Scanner;

public class ZeroSumSubarrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Sum 0 has occurred once before starting the array
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            // If prefixSum was seen before,
            // a zero-sum subarray exists
            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }

            // Increase frequency of this prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println("Number of zero-sum subarrays = " + count);

        sc.close();
    }
}