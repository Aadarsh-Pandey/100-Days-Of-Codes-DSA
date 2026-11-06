import java.util.*;

public class CountInversion {

    public static List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        int[] count = new int[n];
        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, count, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int x : count) {
            result.add(x);
        }

        return result;
    }

    static void mergeSort(int[] nums, int[] indexes,
                          int[] count, int left, int right) {

        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, indexes, count, left, mid);
        mergeSort(nums, indexes, count, mid + 1, right);

        merge(nums, indexes, count, left, mid, right);
    }

    static void merge(int[] nums, int[] indexes,
                      int[] count, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;
        int smaller = 0;

        while (i <= mid && j <= right) {

            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k++] = indexes[j++];
                smaller++;
            } else {
                count[indexes[i]] += smaller;
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            count[indexes[i]] += smaller;
            temp[k++] = indexes[i++];
        }

        while (j <= right) {
            temp[k++] = indexes[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            indexes[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 6, 1};

        System.out.println(countSmaller(nums));
    }
}
