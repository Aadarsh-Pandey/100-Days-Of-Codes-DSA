import java.util.*;

public class TopologicalSortKahnasAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.offer(i);

        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            count++;

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        if (count != V)
            System.out.println("\nCycle detected");
    }
}
