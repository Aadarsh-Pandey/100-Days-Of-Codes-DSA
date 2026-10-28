import java.util.*;

public class Dijkstra {
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

        int source = sc.nextInt();

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;

        java.util.PriorityQueue<long[]> pq =
            new java.util.PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1])
            );

        pq.add(new long[]{source, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d != dist[u])
                continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new long[]{v, dist[v]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE)
                System.out.print("-1");
            else
                System.out.print(dist[i]);

            if (i < n)
                System.out.print(" ");
        }

        System.out.println();
        sc.close();
    }
}
