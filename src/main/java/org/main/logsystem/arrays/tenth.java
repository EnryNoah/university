package org.main.logsystem.arrays;

import java.util.Arrays;

public class tenth {
    public static int[] moveEvenOdd(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 4};
        System.out.println("Output: " + Arrays.toString(moveEvenOdd(nums1)));

        int[] nums2 = {0};
        System.out.println("Output: " + Arrays.toString(moveEvenOdd(nums2)));
    }
}
