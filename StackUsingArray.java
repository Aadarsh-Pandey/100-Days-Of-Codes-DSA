import java.util.Scanner;

public class StackUsingArray {

    static int[] stack;
    static int top = -1;

    // Push operation
    static void push(int value) {

        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        stack[top] = value;

        System.out.println(value + " pushed into stack.");
    }

    // Pop operation
    static void pop() {

        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println(stack[top] + " popped from stack.");
        top--;
    }

    // Display operation
    static void display() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements:");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        stack = new int[size];

        int choice;

        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}