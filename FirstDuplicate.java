import java.util.*;

class FirstDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) {
                System.out.println(c);
                return;
            }
            seen[c - 'a'] = true;
        }

        System.out.println(-1);
    }
}