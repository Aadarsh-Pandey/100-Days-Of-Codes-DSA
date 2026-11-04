import java.util.*;

public class BucketSort {

    static void bucketSort(double[] arr) {
        int n = arr.length;

        // Step 1: Create buckets
        ArrayList<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2: Distribute elements into buckets
        for (double num : arr) {
            int index = (int) (n * num);
            buckets[index].add(num);
        }

        // Step 3: Sort each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Step 4: Concatenate buckets
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (double num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        bucketSort(arr);

        for (double num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}