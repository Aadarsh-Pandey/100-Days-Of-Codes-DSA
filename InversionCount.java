import java.util.*;

public class InversionCount {

    static long mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        long count = 0;

        // Count inversions in left half
        count += mergeSort(arr, low, mid);

        // Count inversions in right half
        count += mergeSort(arr, mid + 1, high);

        // Count cross inversions
        count += merge(arr, low, mid, high);

        return count;
    }

    static long merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // All remaining elements in left half
                // form inversions with arr[j - 1]
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(mergeSort(arr, 0, n - 1));

        sc.close();
    }
}