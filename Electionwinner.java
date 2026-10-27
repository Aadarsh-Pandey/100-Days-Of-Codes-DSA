import java.util.*;

class Electionwinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<String, Integer> votes = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            votes.put(name, votes.getOrDefault(name, 0) + 1);
        }

        String winner = "";
        int max = 0;

        for (String name : votes.keySet()) {
            int count = votes.get(name);

            if (count > max) {
                max = count;
                winner = name;
            }
        }

        System.out.println(winner + " " + max);
        sc.close();
    }
}