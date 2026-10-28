import java.util.*;

public class MST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];

        java.util.PriorityQueue<int[]> pq =
            new java.util.PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
            );

        pq.add(new int[]{1, 0});

        long totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];

            if (visited[u])
                continue;

            visited[u] = true;
            totalWeight += w;
            count++;

            for (int[] edge : adj[u]) {
                if (!visited[edge[0]]) {
                    pq.add(new int[]{edge[0], edge[1]});
                }
            }
        }

        if (count == n)
            System.out.println(totalWeight);
        else
            System.out.println("MST not possible");

        sc.close();
    }
}