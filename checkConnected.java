import java.util.*;

public class checkConnected {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

    static void dfs(int u) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.println("NOT CONNECTED");
                sc.close();
                return;
            }
        }

        System.out.println("CONNECTED");
        sc.close();
    }
}