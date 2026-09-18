import java.util.Scanner;

public class PowerRecursive {

    static int power(int a, int b) {
        // Base case
        if (b == 0) {
            return 1;
        }

        // Recursive case
        return a * power(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        System.out.println(a + "^" + b + " = " + power(a, b));

        sc.close();
    }
}
