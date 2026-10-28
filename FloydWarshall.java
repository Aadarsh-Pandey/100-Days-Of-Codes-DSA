import java.util.*;

public class FloydWarshall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] dist = new long[n][n];
        long INF = Long.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();

                if (x == -1 && i != j)
                    dist[i][j] = INF;
                else
                    dist[i][j] = x;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("-1");
                else
                    System.out.print(dist[i][j]);

                if (j < n - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}