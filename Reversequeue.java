import java.util.*;

public class Reversequeue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        // Insert elements into the queue
        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }

        // Transfer queue elements to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Transfer stack elements back to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Print the reversed queue
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
            if (!queue.isEmpty()) {
                System.out.print(" ");
            }
        }

        System.out.println();
        sc.close();
    }
}