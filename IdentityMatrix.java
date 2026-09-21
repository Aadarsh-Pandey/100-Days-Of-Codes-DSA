import java.util.Scanner;

public class IdentityMatrix {
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

        boolean isIdentity = true;

        // Check identity matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j && matrix[i][j] != 1) {
                    isIdentity = false;
                    break;
                }

                if (i != j && matrix[i][j] != 0) {
                    isIdentity = false;
                    break;
                }
            }

            if (!isIdentity) {
                break;
            }
        }

        // Display result
        if (isIdentity) {
            System.out.println("Matrix is an Identity Matrix");
        } else {
            System.out.println("Matrix is not an Identity Matrix");
        }

        sc.close();
    }
}
