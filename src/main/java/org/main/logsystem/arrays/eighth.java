package org.main.logsystem.arrays;

public class eighth {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n - 1 && arr[i] < arr[i + 1])
            i++;

        if (i == 0 || i == n - 1)
            return false;

        while (i < n - 1 && arr[i] > arr[i + 1])
            i++;

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1};
        System.out.println("Output: " + validMountainArray(arr1));

        int[] arr2 = {3, 5, 5};
        System.out.println("Output: " + validMountainArray(arr2));

        int[] arr3 = {0, 3, 2, 1};
        System.out.println("Output: " + validMountainArray(arr3));
    }
}
