import java.util.*;

class BellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int src = sc.nextInt();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < n; i++) {
            boolean changed = false;

            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    changed = true;
                }
            }

            if (!changed) break;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + w < dist[v]) {
                System.out.println("NEGATIVE CYCLE");
                sc.close();
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " " +
                (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }

        sc.close();
    }
}