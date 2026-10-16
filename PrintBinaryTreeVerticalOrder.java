
import java.util.*;

public class PrintBinaryTreeVerticalOrder {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < n) {
            Node curr = q.poll();

            if (i < n && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.offer(curr.left);
            }
            i++;

            if (i < n && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    static void verticalOrder(Node root) {
        if (root == null) return;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});

        while (!q.isEmpty()) {
            Object[] item = q.poll();
            Node node = (Node) item[0];
            int hd = (int) item[1];

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null)
                q.offer(new Object[]{node.left, hd - 1});

            if (node.right != null)
                q.offer(new Object[]{node.right, hd + 1});
        }

        for (List<Integer> column : map.values()) {
            for (int val : column)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Node root = buildTree(arr, n);
        verticalOrder(root);

        sc.close();
    }
}
