package org.main.logsystem.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sixth {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sixth solution = new Sixth();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
