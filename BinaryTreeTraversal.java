
import java.util.*;

public class BinaryTreeTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Construct binary tree from level-order traversal
    static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < n && !queue.isEmpty()) {
            Node current = queue.poll();

            // Left child
            if (i < n && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < n && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);

        inorder(root);
        System.out.println();

        preorder(root);
        System.out.println();

        postorder(root);
        System.out.println();

        sc.close();
    }
}