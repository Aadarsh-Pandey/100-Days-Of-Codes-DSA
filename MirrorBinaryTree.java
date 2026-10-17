import java.util.*;

public class MirrorBinaryTree {
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

    static void mirror(Node root) {
        if (root == null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Node root = buildTree(arr, n);
        mirror(root);
        inorder(root);

        sc.close();
    }
}
