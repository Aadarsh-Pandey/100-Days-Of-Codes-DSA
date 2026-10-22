import java.util.*;

public class Dfsgraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int u) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int s = sc.nextInt();
        visited = new boolean[n];

        dfs(s);
        sc.close();
    }
}