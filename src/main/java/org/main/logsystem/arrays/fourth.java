package org.main.logsystem.arrays;

import java.util.Arrays;

public class fourth {
    public static void duplicateZeros(int[] arr) {
        int length = arr.length;
        int zerosToDuplicate = 0;

        for (int num : arr) {
            if (num == 0) {
                zerosToDuplicate++;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                if (i + zerosToDuplicate < length) {
                    arr[i + zerosToDuplicate] = 0;
                }
                zerosToDuplicate--;
            }

            if (i + zerosToDuplicate < length) {
                arr[i + zerosToDuplicate] = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3};
        duplicateZeros(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
