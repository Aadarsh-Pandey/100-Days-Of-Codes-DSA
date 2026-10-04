import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    // Check priority of operators
    static int precedence(char ch) {

        if (ch == '^') {
            return 3;
        }
        else if (ch == '*' || ch == '/') {
            return 2;
        }
        else if (ch == '+' || ch == '-') {
            return 1;
        }

        return 0;
    }

    // Check whether character is an operator
    static boolean isOperator(char ch) {

        return ch == '+' || ch == '-' ||
               ch == '*' || ch == '/' ||
               ch == '^';
    }

    // Convert infix to postfix
    static String infixToPostfix(String expression) {

        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // If operand, add directly to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }

                stack.pop(); // Remove '('
            }

            // Operator
            else if (isOperator(ch)) {

                while (!stack.isEmpty() &&
                       stack.peek() != '(' &&
                       precedence(stack.peek()) >= precedence(ch)) {

                    postfix += stack.pop();
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String expression = sc.nextLine();

        String postfix = infixToPostfix(expression);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}