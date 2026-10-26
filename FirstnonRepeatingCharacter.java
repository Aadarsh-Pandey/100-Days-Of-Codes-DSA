import java.util.*;

class FirstnonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                System.out.println(c);
                return;
            }
        }

        System.out.println('$');
    }
}