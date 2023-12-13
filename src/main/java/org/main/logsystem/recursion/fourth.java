package org.main.logsystem.recursion;

public class fourth {
    public static int countWaysToClimbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        return countWaysToClimbStairs(n - 1) + countWaysToClimbStairs(n - 2);
    }

    public static void main(String[] args) {
        // Example 1
        int n1 = 2;
        System.out.println("Ways to climb to the top with " + n1 + " steps: " + countWaysToClimbStairs(n1));

        // Example 2
        int n2 = 3;
        System.out.println("Ways to climb to the top with " + n2 + " steps: " + countWaysToClimbStairs(n2));
    }
}
