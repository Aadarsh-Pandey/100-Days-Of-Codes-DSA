import java.util.Scanner;

public class FrequencyCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        // Input array
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Frequency of each element:");

        for (int i = 0; i < n; i++) {

            // Skip if already counted
            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + " = " + count);
        }

        sc.close();
    }
}
