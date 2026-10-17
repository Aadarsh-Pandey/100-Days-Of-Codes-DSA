import java.util.*;

public class SymmetricBinaryTreeCheck{
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

    static boolean isMirror(Node a, Node b) {
        if (a == null || b == null) return a == b;

        return a.data == b.data
            && isMirror(a.left, b.right)
            && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Node root = buildTree(arr, n);

        System.out.println(
            root == null || isMirror(root.left, root.right)
                ? "YES" : "NO"
        );
        sc.close();
    }
}
