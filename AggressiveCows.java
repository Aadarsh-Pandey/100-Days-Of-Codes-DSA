
import java.util.*;

public class AggressiveCows {

    static boolean canPlace(int[] stalls, int k, int distance) {
        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        Arrays.sort(stalls);

        int left = 1;
        int right = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlace(stalls, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
