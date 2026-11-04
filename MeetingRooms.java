import java.util.Arrays;
import java.util.Scanner;

public class MeetingRooms {

    static int minMeetingRooms(int[][] meetings) {

        int n = meetings.length;

        // Sort meetings by starting time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Create Min Heap using fully qualified name
        java.util.PriorityQueue<Integer> pq =
                new java.util.PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {

            // Reuse room if previous meeting has ended
            if (!pq.isEmpty() && pq.peek() <= meetings[i][0]) {
                pq.poll();
            }

            // Add current meeting's ending time
            pq.offer(meetings[i][1]);
        }

        // Number of rooms required
        return pq.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        System.out.println(minMeetingRooms(meetings));

        sc.close();
    }
}