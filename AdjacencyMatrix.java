import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] adj = new int[n][n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1; // For undirected graph
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
