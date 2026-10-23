import java.util.*;

public class UndirectedGraphDFS {
    static boolean dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[u] = true;

        for (int v : adj.get(u)) {
            if (!vis[v]) {
                if (dfs(v, u, adj, vis)) return true;
            } else if (v != parent) {
                return true;
            }
        }
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
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, -1, adj, vis)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}