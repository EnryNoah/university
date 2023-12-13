package org.main.logsystem.arrays;

import java.util.Arrays;

public class fifth {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0)
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];

        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2 = {2, 5, 6};
        int n1 = 3;
        merge(nums1, m1, nums2, n1);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1};
        int m2 = 1;
        int[] nums4 = {};
        int n2 = 0;
        merge(nums3, m2, nums4, n2);
        System.out.println(Arrays.toString(nums3));

        int[] nums5 = {0};
        int m3 = 0;
        int[] nums6 = {1};
        int n3 = 1;
        merge(nums5, m3, nums6, n3);
        System.out.println(Arrays.toString(nums5));
    }
}
