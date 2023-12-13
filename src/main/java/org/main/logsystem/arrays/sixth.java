package org.main.logsystem.arrays;

import java.util.Arrays;

public class sixth {

    // All elements that was deleted equal: -1
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int uniqueCount = 1;

        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[i - 1])
                nums[uniqueCount++] = nums[i];

        for (int i = uniqueCount; i < nums.length; i++)
            nums[i] = -1;

        return uniqueCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int result1 = removeDuplicates(nums1);
        System.out.println("Output: " + result1 + ", nums = " + Arrays.toString(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result2 = removeDuplicates(nums2);
        System.out.println("Output: " + result2 + ", nums = " + Arrays.toString(nums2));
    }
}
