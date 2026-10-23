import java.util.*;

public class TopologicalSortDFS {
    static void dfs(int u, ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis, Stack<Integer> st) {
        vis[u] = true;

        for (int v : adj.get(u)) {
            if (!vis[v])
                dfs(v, adj, vis, st);
        }

        st.push(u);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfs(i, adj, vis, st);
        }

        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
    }
}