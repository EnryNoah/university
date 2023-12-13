package org.main.logsystem.arrays;

import java.util.Arrays;

public class ninth {
    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {17, 18, 5, 4, 6, 1};
        System.out.println("Output: " + Arrays.toString(replaceElements(arr1)));

        int[] arr2 = {400};
        System.out.println("Output: " + Arrays.toString(replaceElements(arr2)));
    }
}
