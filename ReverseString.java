import java.util.Scanner;   //Mirror the code name entered by the user

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter code name: ");
        String str = sc.nextLine();

        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }

        System.out.println("Mirror format: " + reverse);

        sc.close();
    }
}
