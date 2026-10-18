import java.util.*;

public class CheckMinHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        boolean valid = true;

        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && a[i] > a[left])
                valid = false;

            if (right < n && a[i] > a[right])
                valid = false;
        }

        System.out.println(valid ? "YES" : "NO");
        sc.close();
    }
}