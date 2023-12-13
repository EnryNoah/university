package org.main.logsystem.recursion;

public class third {
    public static int calculateFibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 4;

        System.out.println("F(" + n1 + ") = " + calculateFibonacci(n1));
        System.out.println("F(" + n2 + ") = " + calculateFibonacci(n2));
        System.out.println("F(" + n3 + ") = " + calculateFibonacci(n3));
    }
}
