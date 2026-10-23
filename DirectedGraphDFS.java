import java.util.*;

public class DirectedGraphDFS {
    static boolean dfs(int u, ArrayList<ArrayList<Integer>> adj,
                       boolean[] vis, boolean[] path) {
        vis[u] = true;
        path[u] = true;

        for (int v : adj.get(u)) {
            if (!vis[v]) {
                if (dfs(v, adj, vis, path)) return true;
            } else if (path[v]) {
                return true;
            }
        }

        path[u] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, adj, vis, path)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}