package org.main.logsystem.recursion;

public class fifth {
    public static double pow(double x, int n) {
        if (n == 0)
            return 1;

        if (n > 0)
            return x * pow(x, n - 1);
        else
            return 1 / (x * pow(x, -n - 1));
    }

    public static void main(String[] args) {
        // Example 1
        double x1 = 2.0;
        int n1 = 10;
        System.out.println("Result for Example 1: " + pow(x1, n1));

        // Example 2
        double x2 = 2.1;
        int n2 = 3;
        System.out.println("Result for Example 2: " + pow(x2, n2));

        // Example 3
        double x3 = 2.0;
        int n3 = -2;
        System.out.println("Result for Example 3: " + pow(x3, n3));
    }
}
