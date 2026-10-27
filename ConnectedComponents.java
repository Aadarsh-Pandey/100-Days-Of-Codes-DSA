import java.util.*;

public class ConnectedComponents {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int components = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                components++;
            }
        }

        System.out.println(components);
        sc.close();
    }
}