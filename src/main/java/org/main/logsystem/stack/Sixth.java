package org.main.logsystem.stack;

import java.util.Stack;

public class Sixth {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens1));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens3));
    }
}
