import java.util.*;

public class BookAllocation {

    public static boolean isPossible(int[] pages, int m, int maxPages) {

        int students = 1;
        int currentPages = 0;

        for (int i = 0; i < pages.length; i++) {

            if (currentPages + pages[i] <= maxPages) {

                currentPages += pages[i];

            } else {

                students++;
                currentPages = pages[i];
            }
        }

        return students <= m;
    }

    public static int allocateBooks(int[] pages, int m) {

        int n = pages.length;

        // More students than books is impossible
        if (m > n) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int p : pages) {
            low = Math.max(low, p);
            high += p;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(pages, m, mid)) {

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
        int m = sc.nextInt();

        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.println(allocateBooks(pages, m));
    }
}