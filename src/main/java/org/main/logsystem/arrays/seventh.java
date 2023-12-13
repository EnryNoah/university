package org.main.logsystem.arrays;

import java.util.HashSet;
import java.util.Set;

public class seventh {
    public static boolean checkIfDoubleExists(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2)))
                return true;

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 2, 5, 3};
        System.out.println("Output: " + checkIfDoubleExists(arr1));

        int[] arr2 = {3, 1, 7, 11};
        System.out.println("Output: " + checkIfDoubleExists(arr2));
    }

}
