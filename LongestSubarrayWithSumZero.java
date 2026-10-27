import java.util.*;

class LongestSubarrayWithSumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0, sum = 0, index = 0;

        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            sum += x;

            if (sum == 0)
                maxLen = index + 1;

            if (map.containsKey(sum))
                maxLen = Math.max(maxLen, index - map.get(sum));
            else
                map.put(sum, index);

            index++;
        }

        System.out.println(maxLen);
        sc.close();
    }
}