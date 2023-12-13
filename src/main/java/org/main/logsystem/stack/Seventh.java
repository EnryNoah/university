package org.main.logsystem.stack;

import java.util.Stack;

public class Seventh {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        System.out.println(longestValidParentheses(s1));

        String s2 = ")()())";
        System.out.println(longestValidParentheses(s2));

        String s3 = "";
        System.out.println(longestValidParentheses(s3));
    }
}
