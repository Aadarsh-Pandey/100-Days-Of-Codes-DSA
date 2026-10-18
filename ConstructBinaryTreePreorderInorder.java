import java.util.*;

public class ConstructBinaryTreePreorderInorder {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] postorder;

    static Node buildTree(int left, int right) {
        if (left > right) return null;

        int val = postorder[postIndex--];
        Node root = new Node(val);
        int mid = map.get(val);

        root.right = buildTree(mid + 1, right);
        root.left = buildTree(left, mid - 1);

        return root;
    }

    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] inorder = new int[n];
        postorder = new int[n];

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            map.put(inorder[i], i);
        }

        for (int i = 0; i < n; i++)
            postorder[i] = sc.nextInt();

        postIndex = n - 1;
        Node root = buildTree(0, n - 1);

        preorder(root);
        sc.close();
    }
}