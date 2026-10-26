import java.util.*;

class QuadraticProbing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int q = sc.nextInt();
        int[] table = new int[m];
        Arrays.fill(table, -1);

        while (q-- > 0) {
            String op = sc.next();
            int key = sc.nextInt();
            int h = key % m;

            if (op.equals("INSERT")) {
                for (int i = 0; i < m; i++) {
                    int idx = (h + i * i) % m;
                    if (table[idx] == -1) {
                        table[idx] = key;
                        break;
                    }
                    if (table[idx] == key) break;
                }
            } else if (op.equals("SEARCH")) {
                boolean found = false;

                for (int i = 0; i < m; i++) {
                    int idx = (h + i * i) % m;

                    if (table[idx] == key) {
                        found = true;
                        break;
                    }
                    if (table[idx] == -1) break;
                }

                System.out.println(found ? "FOUND" : "NOT FOUND");
            }
        }

        sc.close();
    }
}
