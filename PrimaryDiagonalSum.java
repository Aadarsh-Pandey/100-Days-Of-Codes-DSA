import java.util.Scanner;

public class PrimaryDiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        // Input matrix
        System.out.println("Enter elements of matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int sum = 0;

        // Calculate primary diagonal sum
        for (int i = 0; i < n; i++) {
            sum = sum + matrix[i][i];
        }

        System.out.println("Sum of primary diagonal = " + sum);

        sc.close();
    }
}
