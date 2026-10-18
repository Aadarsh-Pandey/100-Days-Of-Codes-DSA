import java.util.*;

public class ConstructBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int preIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static Node buildTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int val = preorder[preIndex++];
        Node root = new Node(val);
        int mid = map.get(val);

        root.left = buildTree(preorder, left, mid - 1);
        root.right = buildTree(preorder, mid + 1, right);

        return root;
    }

    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            map.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, n - 1);
        postorder(root);

        sc.close();
    }
}