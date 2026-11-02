import java.util.*;

public class PainterPartitionProblem {

    public static boolean isPossible(int[] boards, int k, int maxTime) {

        int painters = 1;
        int currentTime = 0;

        for (int i = 0; i < boards.length; i++) {

            if (currentTime + boards[i] <= maxTime) {

                currentTime += boards[i];

            } else {

                painters++;
                currentTime = boards[i];
            }
        }

        return painters <= k;
    }

    public static int minTime(int[] boards, int k) {

        int n = boards.length;

        if (k > n) {
            return -1;
        }

        int low = 0;
        int high = 0;

        // Find search space
        for (int b : boards) {
            low = Math.max(low, b);
            high += b;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(boards, k, mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] boards = new int[n];

        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
        }

        System.out.println(minTime(boards, k));
    }
}