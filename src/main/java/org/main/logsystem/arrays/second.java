package org.main.logsystem.arrays;

public class second {
    public static void main(String[] args) {
        int[] nums1 = {12, 345, 2, 6, 7896};
        int[] nums2 = {555, 901, 482, 1771};

        System.out.println(findNumbers(nums1));
        System.out.println(findNumbers(nums2));
    }

    private static int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums)
            if (hasEvenDigits(num))
                count++;

        return count;
    }

    private static boolean hasEvenDigits(int num) {
        int digitCount = 0;

        while (num != 0) {
            num /= 10;
            digitCount++;
        }

        return digitCount % 2 == 0;
    }
}
