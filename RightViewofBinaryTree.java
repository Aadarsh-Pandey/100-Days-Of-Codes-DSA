import java.util.*;

public class RightViewofBinaryTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    static Node buildTree(int[] a, int n) {
        if (n == 0 || a[0] == -1) return null;

        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < n) {
            Node cur = q.poll();

            if (i < n && a[i] != -1) {
                cur.left = new Node(a[i]);
                q.offer(cur.left);
            }
            i++;

            if (i < n && a[i] != -1) {
                cur.right = new Node(a[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    static void rightView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                if (i == size - 1)
                    System.out.print(cur.data + " ");

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        rightView(buildTree(a, n));
        sc.close();
    }
}