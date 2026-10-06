import java.util.Scanner;

public class PriorityQueue {

    static int[] queue;
    static int size = 0;

    // Insert element
    static void insert(int x) {
        queue[size] = x;
        size++;
    }

    // Delete element with highest priority
    static int delete() {

        if (size == 0) {
            return -1;
        }

        // Find the smallest element
        int minIndex = 0;

        for (int i = 1; i < size; i++) {
            if (queue[i] < queue[minIndex]) {
                minIndex = i;
            }
        }

        int deleted = queue[minIndex];

        // Shift elements to fill the gap
        for (int i = minIndex; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        size--;

        return deleted;
    }

    // Peek highest priority element
    static int peek() {

        if (size == 0) {
            return -1;
        }

        int minIndex = 0;

        for (int i = 1; i < size; i++) {
            if (queue[i] < queue[minIndex]) {
                minIndex = i;
            }
        }

        return queue[minIndex];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // Maximum possible operations = N
        queue = new int[N];

        for (int i = 0; i < N; i++) {

            String operation = sc.next();

            if (operation.equals("insert")) {

                int x = sc.nextInt();
                insert(x);

            } else if (operation.equals("delete")) {

                System.out.println(delete());

            } else if (operation.equals("peek")) {

                System.out.println(peek());
            }
        }

        sc.close();
    }
}