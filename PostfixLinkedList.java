import java.util.Scanner;

public class PostfixLinkedList {

    // Node for stack
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    // Push operation
    static void push(int value) {

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    static int pop() {

        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;

        return value;
    }

    // Check whether stack is empty
    static boolean isEmpty() {
        return top == null;
    }

    // Evaluate postfix expression
    static int evaluatePostfix(String expression) {

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            // If token is a number
            if (token.matches("-?\\d+")) {

                push(Integer.parseInt(token));
            }

            // If token is an operator
            else {

                int b = pop();
                int a = pop();

                int result = 0;

                switch (token) {

                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                push(result);
            }
        }

        return pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String expression = sc.nextLine();

        int result = evaluatePostfix(expression);

        System.out.println("Result = " + result);

        sc.close();
    }
}